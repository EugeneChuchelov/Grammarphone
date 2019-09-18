package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Grammar implements Serializable {
    private List<Character> terminal;
    private List<Character> notTerminal;
    private Set<Rule> rules;

    public List<Character> getTerminal() {
        return terminal;
    }

    public void setTerminal(List<Character> terminal) {
        this.terminal = terminal;
    }

    public List<Character> getNotTerminal() {
        return notTerminal;
    }

    public void setNotTerminal(List<Character> notTerminal) {
        this.notTerminal = notTerminal;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
}
