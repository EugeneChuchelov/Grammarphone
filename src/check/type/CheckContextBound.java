package check.type;

import entity.Grammar;
import entity.Rule;

public class CheckContextBound {

    public static boolean isContextBound(Grammar grammar) {
        boolean isCX = true;
        for (Rule rule : grammar.getRules()) {
            if(!(isLeftNotContainEmptyChain(rule) && isRightLonger(rule)))
            isCX = false;
        }
        return isCX;
    }

    private static boolean isLeftNotContainEmptyChain(Rule rule) {
        return !rule.getFrom().contains('\0');
    }

    private static boolean isRightLonger(Rule rule) {
        return rule.getFrom().size() <= rule.getTo().size();
    }
}
