package check.type;

import entity.Grammar;
import entity.Rule;
import java.util.List;

public class CheckContextDependent {

    public static boolean isContextDependent(Grammar grammar) {
        boolean isCX = true;
        for (Rule rule : grammar.getRules()) {
            if(!(isLeftNotContainEmptyChain(rule) && isRightLonger(rule) && isContextSimilar(rule, grammar.getNotTerminal())))
            isCX = false;
        }
        return isCX;
    }

    private static boolean isLeftNotContainEmptyChain(Rule rule) {
        return !rule.getFrom().contains('\r');
    }

    private static boolean isRightLonger(Rule rule) {
        return rule.getFrom().size() <= rule.getTo().size();
    }

    private static boolean isContextSimilar(Rule rule, List<Character> notTerminals){
        int indexLeft = findLeftNotTerminalIndex(rule.getFrom(), notTerminals);
        int indexRight = findRightNotTerminalIndex(rule.getFrom(), notTerminals);

        List<Character> fromContextLeft = rule.getFrom().subList(0, indexLeft);
        List<Character> fromContextRight = rule.getFrom().subList(indexRight + 1, rule.getFrom().size());

        if(fromContextLeft.size() == 0 && fromContextRight.size() == 0)
            return true;

        List<Character> toContextLeft = rule.getFrom().subList(0, fromContextLeft.size());

        List<Character> toContextRight = rule.getFrom().subList(rule.getTo().size() - fromContextRight.size(), rule.getTo().size());

        return fromContextLeft.equals(toContextLeft) && fromContextRight.equals(toContextRight);
    }

    private static int findLeftNotTerminalIndex(List<Character> ruleFrom, List<Character> notTerminals){
        int index = -1;
        for(int i = 0; i < ruleFrom.size(); i++){
            if(notTerminals.contains(ruleFrom.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findRightNotTerminalIndex(List<Character> ruleFrom, List<Character> notTerminals){
        int index = -1;
        for(int i = ruleFrom.size() - 1; i >= 0; i--){
            if(notTerminals.contains(ruleFrom.get(i))){
                index = i;
                break;
            }
        }
        return index;
    }

}
