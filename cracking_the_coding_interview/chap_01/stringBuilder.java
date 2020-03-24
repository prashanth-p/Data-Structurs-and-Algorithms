import java.util.*;


class stringBuilderTest {
    public static String joinWords(String[] words){
        StringBuilder sentence = new StringBuilder();
        for(String w: words){
            sentence.append(w);
            sentence.append(" ");
        }
        return sentence.toString();
    }

    public static void main(String[] args){
        String[] s1 = {"happy", "feet", "is", "cool"};

        String res = joinWords(s1);
        System.out.println(res);
    }
}