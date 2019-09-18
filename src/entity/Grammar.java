package entity;

import entity.symbol.NotTerminal;
import entity.symbol.Terminal;

import java.util.Set;

public class Grammar {
    private Set<Terminal> terminal;
    private Set<NotTerminal> notTerminal;
    private Set<Rule> rules;

    public Set<Terminal> getTerminal() {
        return terminal;
    }

    public Set<NotTerminal> getNotTerminal() {
        return notTerminal;
    }

    public Set<Rule> getRules() {
        return rules;
    }
}
