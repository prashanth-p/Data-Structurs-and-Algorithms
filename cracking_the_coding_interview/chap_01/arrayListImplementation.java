import java.util.*;

class arrayListImp {

    public static ArrayList<String> merge(String[] s1, String[] s2){
        ArrayList<String> sentence = new ArrayList<String>();
        for(String s: s1) sentence.add(s);
        for(String s: s2) sentence.add(s);
        return sentence;
    }
    public static void main(String[] args) {

        String[] s1 = {"happy","cool","feet"};
        String[] s2 = {"java","is","awesome"};
        ArrayList<String> res = merge(s1,s2);
        // System.out.println(res.size());

        for(int i=0; i< res.size();i++){
            // System.out.println(i);
            System.out.print(res.get(i) + " ");
        }

        System.out.println();
    }
}