package entity;

import java.io.Serializable;
import java.util.Set;

public class Grammar implements Serializable {
    private char[] terminal;
    private char[] notTerminal;
    private Set<Rule> rules;

    public char[] getTerminal() {
        return terminal;
    }

    public void setTerminal(char[] terminal) {
        this.terminal = terminal;
    }

    public char[] getNotTerminal() {
        return notTerminal;
    }

    public void setNotTerminal(char[] notTerminal) {
        this.notTerminal = notTerminal;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
}
