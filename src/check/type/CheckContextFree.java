package check.type;

import entity.Grammar;
import entity.Rule;

import static util.Contains.contains;

public class CheckContextFree {

    public static boolean isContextFree(Grammar grammar){
        boolean isCF = true;
        for(Rule rule : grammar.getRules()){
            isCF = isLeftNotTerminal(rule, grammar.getNotTerminal());
        }
        return isCF;
    }

    private static boolean isLeftNotTerminal(Rule rule, char[] notTerminal){
        if(rule.getFrom().length != 1)
            return false;
        return contains(notTerminal, rule.getFrom()[0]);
    }
}
