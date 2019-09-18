package check.type;

import entity.Grammar;
import entity.Rule;
import entity.symbol.NotTerminal;

import java.util.Collection;
import java.util.Set;

public class Check {

    private boolean isRegular(Grammar grammar){

    }

    private boolean isLeftNotTerminal(Rule rule, Set<NotTerminal> notTerminal){
        if(rule.getFrom().size() != 1)
            return false;
        if(notTerminal.contains(rule.getFrom().get(0))){
            return true;
        }
        return false;
    }
}
