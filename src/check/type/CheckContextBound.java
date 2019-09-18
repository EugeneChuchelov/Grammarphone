package check.type;

import entity.Grammar;
import entity.Rule;

import static util.Contains.contains;

public class CheckContextBound {

    public static boolean isContextBound(Grammar grammar){
        boolean isCX = true;
        for(Rule rule : grammar.getRules()){
            isCX = isLeftNotEmpty(rule) && isRightLonger(rule);
        }
        return isCX;
    }

    private static boolean isLeftNotEmpty(Rule rule){
        return contains(rule.getFrom(), '\0');
    }

    private static boolean isRightLonger(Rule rule){
        return rule.getFrom().length <= rule.getTo().length;
    }
}
