package entity;

import java.util.Set;

public class Grammar {
    private char[] terminal;
    private char[] notTerminal;
    private Set<Rule> rules;

    public char[] getTerminal() {
        return terminal;
    }

    public char[] getNotTerminal() {
        return notTerminal;
    }

    public Set<Rule> getRules() {
        return rules;
    }
}
