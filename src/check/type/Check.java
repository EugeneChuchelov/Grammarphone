package check.type;

import entity.Grammar;
import entity.Type;

import static check.type.CheckContextDependent.isContextDependent;
import static check.type.CheckContextFree.isContextFree;
import static check.type.CheckRegular.isRegular;

public class Check {
    public static Type check(Grammar grammar) {
        if(!preCheck(grammar))
            return Type.Defected;

        if(isContextDependent(grammar)){
            if(isContextFree(grammar)){
                if(isRegular(grammar)){
                    return Type.Regular;
                } else {
                    return Type.ContextFree;
                }
            } else {
                return Type.ContextDependent;
            }
        } else {
            return Type.Zero;
        }
    }

    private static boolean preCheck(Grammar grammar) {
        for(Character character : grammar.getNotTerminal()){
            if(grammar.getTerminal().contains(character))
                return false;
        }
        return true;
    }
}
