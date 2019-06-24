package Chap1;

public class Prob1_2 {

    // Linear time solution with no data structures.
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int total = 0;
        for (int i = 0; i < str1.length(); i++) {
            total += str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            total -= str2.charAt(i);
        }

        return total == 0;
    }

    // Linear time solution with constant space and data structures.
    public static boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charSet = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int val1 = str1.charAt(i);
            int val2 = str2.charAt(i);
            charSet[val1]++;
            charSet[val2]--;
        }
        for (int i = 0; i < charSet.length; i++) {
            if (charSet[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Expected true.
        System.out.println(isPermutation("racecar", "aaccerr"));
        // Expected false.
        System.out.println(isPermutation("racecar", "anand"));
        // Expected true.
        System.out.println(isPermutation2("racecar", "aaccerr"));
        // Expected false.
        System.out.println(isPermutation2("racecar", "anand"));
    }
}
