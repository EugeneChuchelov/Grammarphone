package entity;

import java.io.Serializable;

public class Rule implements Serializable {
    private char[] from;
    private char[] to;

    public char[] getFrom() {
        return from;
    }

    public void setFrom(char[] from) {
        this.from = from;
    }

    public char[] getTo() {
        return to;
    }

    public void setTo(char[] to) {
        this.to = to;
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
