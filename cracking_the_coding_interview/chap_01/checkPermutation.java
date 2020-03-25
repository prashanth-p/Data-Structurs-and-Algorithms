import java.util.Arrays;

/*package cracking_the_coding_interview.chap_01;

/**
 * checkPermutation
 * 1.2 Check Permutation: Given two strings, write a method to decide
 * if one is a permutation of the other.
 */

import java.util.*;

public class checkPermutation {

    static int NO_OF_CHARS = 256;

    public static boolean checkIsPermutation(String s1, String s2){
        
        int[] char_set = new int[NO_OF_CHARS];
        Arrays.fill(char_set, 0);

        if(s1.length() != s2.length())
            return false;
        
        int asciiVal = 0;
        for(int i=0; i<s1.length(); i++){
            asciiVal = s1.charAt(i);
            char_set[asciiVal]++;    
        }

        for(int i=0; i<s2.length();i++) {
            asciiVal = s2.charAt(i);
            char_set[asciiVal]--;

            if(char_set[asciiVal]<0)
                return false;
        }

        for(int i=0; i<NO_OF_CHARS; i++){
            if(char_set[i]>0){
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