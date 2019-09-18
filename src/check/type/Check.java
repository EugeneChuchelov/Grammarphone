package check.type;

import entity.Grammar;
import entity.Type;

import static check.type.CheckContextBound.isContextBound;
import static check.type.CheckContextFree.isContextFree;
import static check.type.CheckRegular.isRegular;

public class Check {
    public static Type check(Grammar grammar) {
        if (isRegular(grammar))
            return Type.RegularRight;
        else if (isContextFree(grammar))
            return Type.ContextFree;
        else if (isContextBound(grammar))
            return Type.ContextBound;
        else
            return Type.Zero;
    }
}
