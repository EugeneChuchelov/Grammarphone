package entity;

import java.util.Collection;
import java.util.List;

public class Rule {
    private List<Object> from;
    private List<Object> to;

    public List<Object> getFrom() {
        return from;
    }

    public List<Object> getTo() {
        return to;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder
//                .append(from)
//                .append(" -> ");
//        for(String s : to){
//            builder
//                    .append(s)
//                    .append('|');
//        }
//        builder.deleteCharAt(builder.lastIndexOf("|"));
//        return builder.toString();
//    }
}
