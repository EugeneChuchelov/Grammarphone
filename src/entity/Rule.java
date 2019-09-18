package entity;

import java.io.Serializable;
import java.util.List;

public class Rule implements Serializable {
    private List<Character> from;
    private List<Character> to;

    public List<Character> getFrom() {
        return from;
    }

    public void setFrom(List<Character> from) {
        this.from = from;
    }

    public List<Character> getTo() {
        return to;
    }

    public void setTo(List<Character> to) {
        this.to = to;
    }
}
