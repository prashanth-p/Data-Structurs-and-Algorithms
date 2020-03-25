/*package cracking_the_coding_interview.chap_01;

/**
 * checkPermutationSorting
 * 1.2 Check Permutation: Given two strings, write a method to decide
 * if one is a permutation of the other.
 */
import java.util.*;

public class checkPermutationSorting {

        public static String sort(String s) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            return new String(sArr);
        }
        public static boolean checkIsPermutation(String s1, String s2) {
            
            if(s1.length() != s2.length())
                return false;

            s1 = sort(s1);
            s2 = sort(s2);
            
            for(int i=0; i<s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
    
            System.out.println("Enter the first word:");
            String s1 = sc.nextLine();
    
            System.out.println("Enter the Second word:");
            String s2 = sc.nextLine(); 
            boolean checkPermutation = checkIsPermutation(s1, s2) ;
    
            if(checkPermutation){
                System.out.println(s1 + " and " + s2 + " are permutations of each other.");
            }   else {
                System.out.println(s1 + " and " + s2 + " are not permutations of each other.");
            } 
        }
    
}