package check.type;

import entity.Grammar;
import entity.Rule;

import java.util.List;

public class CheckRegular {

    public static boolean isRegular(Grammar grammar) {
        boolean isRegular = true;

        for (Rule rule : grammar.getRules()) {
            if (!(isLeftNotTerminal(rule, grammar.getNotTerminal()) &&
                    ((isRightEndsWithNotTerminal(rule, grammar.getNotTerminal())
                            || isRightBeginsWithNotTerminal(rule, grammar.getNotTerminal()))
                            || isRightContainsOnlyTerminals(rule, grammar.getTerminal()))))
                isRegular = false;
        }

        return isRegular;
    }

    private static boolean isLeftNotTerminal(Rule rule, List<Character> notTerminal) {
        if (rule.getFrom().size() != 1)
            return false;

        return notTerminal.containsAll(rule.getFrom());
    }

    private static boolean isRightEndsWithNotTerminal(Rule rule, List<Character> notTerminal) {
        if (rule.getTo().size() > 1)
            return notTerminal.contains(rule.getTo().get(rule.getTo().size() - 1))
                    && rule.getTo().indexOf(rule.getTo().get(rule.getTo().size() - 1)) == rule.getTo().size() - 1;
        else
            return notTerminal.contains(rule.getTo().get(rule.getTo().size() - 1));
    }

    private static boolean isRightBeginsWithNotTerminal(Rule rule, List<Character> notTerminal) {
        if (rule.getTo().size() > 1)
            return notTerminal.contains(rule.getTo().get(0))
                    && rule.getTo().lastIndexOf(rule.getTo().get(0)) == 0;
        else
            return notTerminal.contains(rule.getTo().get(0));
    }

    private static boolean isRightContainsOnlyTerminals(Rule rule, List<Character> terminal) {
        return terminal.containsAll(rule.getTo());
    }
}
