package stargazer.server.domain;

import java.util.List;

/**
 * A minimum information block that is returned from calling
 * http://blockchain.info/latestblock
 *
 * @author restrada
 *
 */
public class LatestBlock {

    private String hash;
    private Long time;
    private Integer block_index;
    private Integer height;
    private List<Integer> txIndexes;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getBlock_index() {
        return block_index;
    }

    public void setBlock_index(Integer block_index) {
        this.block_index = block_index;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Integer> getTxIndexes() {
        return txIndexes;
    }

    public void setTxIndexes(List<Integer> txIndexes) {
        this.txIndexes = txIndexes;
    }    
}
