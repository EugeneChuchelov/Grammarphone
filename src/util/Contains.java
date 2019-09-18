package util;

public class Contains {
    //Is 'contained' contained in 'contains'
    public static boolean contains(char[] contains, char contained){
        for(char c : contains){
            if(c == contained)
                return true;
        }
        return false;
    }

    //Is all chars from 'contained' contained in 'contains'
    public static boolean contains(char[] contains, char[] contained){
        for(char c : contained){
            if(!contains(contains, c)){
                return false;
            }
        }
        return true;
    }
}
