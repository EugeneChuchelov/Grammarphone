package check.type;

import entity.Grammar;
import entity.Rule;

import static util.Contains.contains;

public class CheckRegular {

    public static boolean isRegular(Grammar grammar){
        boolean isRegular = true;

        for(Rule rule : grammar.getRules()){
            isRegular = isLeftNotTerminal(rule, grammar.getNotTerminal()) &&
                    ((isRightEndsWithNotTerminal(rule, grammar.getNotTerminal())
                            || isRightBeginsWithNotTerminal(rule, grammar.getNotTerminal()))
                    || isRightContainsOnlyTerminals(rule, grammar.getTerminal()));
        }

        return isRegular;
    }

    private static boolean isLeftNotTerminal(Rule rule, char[] notTerminal){
        if(rule.getFrom().length != 1)
            return false;
        return contains(notTerminal, rule.getFrom()[0]);
    }

    private static boolean isRightEndsWithNotTerminal(Rule rule, char[] notTerminal){
        return contains(notTerminal, rule.getFrom()[rule.getTo().length - 1]);
    }

    private static boolean isRightBeginsWithNotTerminal(Rule rule, char[] notTerminal){
        return contains(notTerminal, rule.getFrom()[0]);
    }

    private static boolean isRightContainsOnlyTerminals(Rule rule, char[] terminal){
        return contains(terminal, rule.getTo());
    }
}
