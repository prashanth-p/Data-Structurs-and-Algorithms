/*package cracking_the_coding_interview.chap_01;

/**
 * isUniqueTest
 */

import java.util.*;
public class isUniqueTest {
    public static boolean isUnique(String s){
        if(s.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i=0; i<s.length(); i++) {
            int asciiVal = s.charAt(i);
            if(char_set[asciiVal]){
                return false;
            }
            char_set[asciiVal] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int t = 0;
        try {
            t = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        for(int i=0;i<t;i++){
            System.out.println("Enter the string to test: ");
            String test = sc.nextLine();
            System.out.println("We are testing " + test + " ...");
            boolean res = isUnique(test);
            if(res){
                System.out.println("True: All unique characters");
            } else {
                System.out.println("False: Repeated characters detected");
            }
        }
        sc.close();
    }
    
}