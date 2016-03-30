package stargazer.server;

import java.io.File;

/**
 * 
 * @author restrada
 */
public class FetcherException extends Exception {

    private Integer failedBlockIndex;

    FetcherException() {
        super("Latest block fetch failed.");
    }

    FetcherException(Integer blockIndex) {
        super("Block Fetch failed on Block: " + blockIndex);
        this.failedBlockIndex = blockIndex;
    }

    FetcherException(String blockHash) {
        super("Block Fetch failed on Block: " + blockHash);
    }

    FetcherException(File file) {
        super("Block Fetch failed on File: " + file.getName());
    }

    public Integer getFailedBlockIndex() {
        return failedBlockIndex;
    }
}
