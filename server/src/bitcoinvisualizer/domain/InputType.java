package stargazer.server.domain;

/**
 * An output.
 *
 * @author restrada
 *
 */
public class InputType {

    private Long sequence;
    private String script;
    private PrevOut prev_out;

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public PrevOut getPrev_out() {
        return prev_out;
    }

    public void setPrev_out(PrevOut prev_out) {
        this.prev_out = prev_out;
    }

}
