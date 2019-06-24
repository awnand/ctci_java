package Chap1;

import java.util.HashSet;

public class Prob1_1 {
    // Simple solution leveraging a set.
    public static boolean isAllUnique(String s) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (charSet.contains(currChar)) {
                return false;
            } else {
                charSet.add(currChar);
            }
        }
        return true;
    }

    // Solution with constant space.  Remember to clarify with interviewer.
    public static boolean isAllUnique2(String s) {
        if (s.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charSet[val]) {
                return false;
            } else {
                charSet[val] = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // Expected true.
        System.out.println(isAllUnique("abcdef"));
        // Expected false.
        System.out.println(isAllUnique("aabbc"));
        // Expected true.
        System.out.println(isAllUnique2("abcdef"));
        // Expected false.
        System.out.println(isAllUnique2("aabbc"));
    }
}
