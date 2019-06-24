package Chap1;

import java.security.cert.TrustAnchor;

public class Prob1_4 {

    public static boolean isPalindronePermutation(String str) {
        str = str.toLowerCase();
        int strLength = str.length();
        int[] strChars = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar != ' ') {
                strChars[currChar]++;
            } else {
                strLength--;
            }
        }


        boolean oddFlag = false;
        for (int i = 0; i < strLength; i++) {
            char currChar = str.charAt(i);
            if (currChar == ' ') {
                continue;
            }
            if (strChars[currChar] % 2 == 1) {
                if (oddFlag) {
                    return false;
                } else {
                    oddFlag = true;
                }
            }
        }
        return true;
}

    public static void main(String[] args) {
        // Expected true.
        System.out.println(isPalindronePermutation("Tact Coa"));
        // Expected false.
        System.out.println(isPalindronePermutation("abcdefg"));
    }
}
