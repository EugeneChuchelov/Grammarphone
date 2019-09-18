package check.type;

import entity.Grammar;
import entity.Rule;

import java.util.List;

public class CheckContextFree {

    public static boolean isContextFree(Grammar grammar) {
        boolean isCF = true;
        for (Rule rule : grammar.getRules()) {
            if (!isLeftNotTerminal(rule, grammar.getNotTerminal()))
                isCF = false;
        }
        return isCF;
    }

    private static boolean isLeftNotTerminal(Rule rule, List<Character> notTerminal) {
        if (rule.getFrom().size() != 1)
            return false;
        return notTerminal.containsAll(rule.getFrom());
    }
}
