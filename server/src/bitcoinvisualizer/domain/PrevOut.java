package stargazer.server.domain;

/**
 * An input abstraction created from the blockchain.info API.
 *
 * @author restrada
 *
 */
public class PrevOut {

    private String hash;
    private Long value;
    private Long tx_index;
    private Integer n;
    private Boolean spent;
    private String script;

    private String addr;
    private String addr2;
    private String addr3;
    private Integer type;
    private String addr_tag;
    private String addr_tag_link;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getTx_index() {
        return tx_index;
    }

    public void setTx_index(Long tx_index) {
        this.tx_index = tx_index;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Boolean getSpent() {
        return spent;
    }

    public void setSpent(Boolean spent) {
        this.spent = spent;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddr_tag() {
        return addr_tag;
    }

    public void setAddr_tag(String addr_tag) {
        this.addr_tag = addr_tag;
    }

    public String getAddr_tag_link() {
        return addr_tag_link;
    }

    public void setAddr_tag_link(String addr_tag_link) {
        this.addr_tag_link = addr_tag_link;
    }

}
