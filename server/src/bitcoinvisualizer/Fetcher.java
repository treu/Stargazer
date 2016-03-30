package stargazer.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.Charset;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.CanReadFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

import stargazer.server.domain.BlockJsonType;
import stargazer.server.domain.BlockType;
import stargazer.server.domain.LatestBlock;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.JSONObject;

/**
 * Fetch the transactions
 * @author restrada
 */
public class Fetcher {

    private static final String BLOCKCHAININFOAPI = "https://blockchain.info/rawblock/";
    private static final String SECRET = ""; //"?api_code=LK75FDss"
    private static final String BLOCKCHAININFOLATEST = "https://blockchain.info/latestblock";
    private static final Logger LOG = Logger.getLogger(Fetcher.class.getName());

    /**
     * Downloads a block by block index.
     *
     * @param index - Index value of the block.
     * @return BlockJsonType
     * @throws FetcherException
     */
    public static BlockJsonType getBlock(Integer index) throws FetcherException {
        LOG.info("Downloading block: " + index);
        URL url;
        try {
            url = new URL(BLOCKCHAININFOAPI + index + SECRET);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
            JSONObject jsonObject = new JSONObject(readAll(reader));

            ObjectMapper objectMapper = new ObjectMapper();
            return new BlockJsonType(objectMapper.readValue(url, BlockType.class), jsonObject);

        } catch (MalformedURLException e) {
            LOG.log(Level.SEVERE, "Fetcher failed.  Reason: " + e.getMessage(), e);
            throw new FetcherException(index);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Fetcher failed.  Reason: " + e.getMessage(), e);
            throw new FetcherException(index);
        }
    }

    /**
     * Downloads a block by block hash.
     *
     * @param blockHash - Hash value of the block.
     * @return BlockJsonType
     * @throws FetcherException
     */
    public static BlockJsonType getBlock(String blockHash) throws FetcherException {
        LOG.info("Downloading block: " + blockHash);
        try {
            URL url = new URL(BLOCKCHAININFOAPI + blockHash + SECRET);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
            JSONObject jsonObject = new JSONObject(readAll(reader));

            ObjectMapper objectMapper = new ObjectMapper();
            return new BlockJsonType(objectMapper.readValue(url, BlockType.class), jsonObject);

        } catch (MalformedURLException e) {
            LOG.log(Level.SEVERE, "Fetcher failed.  Reason: " + e.getMessage(), e);
            throw new FetcherException(blockHash);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Fetcher failed.  Reason: " + e.getMessage(), e);
            throw new FetcherException(blockHash);
        }
    }

    /*
    public static void main(String[] args) {

        try {
            //getBlock("0000000000000000051830a050b83e90e8cf2bf76abc84fabb141867d35a0f56");
            getBlock(1101274);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    */

    //TODO: remove this method
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Converts a JSON file from disk to a BlockJsonType
     *
     * @param file - a .json file from disk.
     * @return
     * @throws FetcherException
     */
    public static BlockJsonType getBlock(File file) throws FetcherException {
        try {

            FileReader fr = new FileReader(file);
            JSONObject jsonObject = new JSONObject(readAll(fr));
            ObjectMapper objectMapper = new ObjectMapper();

            return new BlockJsonType(objectMapper.readValue(file, BlockType.class), jsonObject);

        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Fetcher failed.  Reason: " + e.getMessage(), e);
            throw new FetcherException(file);

        }
    }

    /**
     * Downloads the latest block from the API.
     *
     * @return LatestBlock
     * @throws FetcherException
     */
    public static LatestBlock getLatest() throws FetcherException {
        LOG.info("Downloading latest block value from the internet...");
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new URL(BLOCKCHAININFOLATEST), LatestBlock.class);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Fetcher failed to retrieve latest block value. Aborting.  Reason: " + e.getMessage(), e);
            throw new FetcherException();
        }
    }

    /**
     * Returns all the files in a directory.
     *
     * @param dir - Path to the directory that contains the text documents to be
     * parsed.
     * @return A collection of File Objects
     */
    public static Collection<File> getFolderContents(String dir) {
        // Collect all readable documents
        File file = new File(dir);
        Collection<File> files = FileUtils.listFiles(file, CanReadFileFilter.CAN_READ, DirectoryFileFilter.DIRECTORY);
        return files;
    }
}
