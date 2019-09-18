package entity;

public class Rule {
    private char[] from;
    private char[] to;

    public char[] getFrom() {
        return from;
    }

    public char[] getTo() {
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
