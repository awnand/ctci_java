package Chap1;

public class Prob1_5 {

    public static boolean isOneEditAway(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        return isOneInsertionAway(str1, str2) || isOneRemovalAway(str1, str2) || isOneReplaceAway(str1, str2);
    }

    private static boolean isOneReplaceAway(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return  false;
        }

        boolean oneReplace = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (oneReplace) {
                    return false;
                } else {
                    oneReplace = true;
                }
            }
        }
        return true;
    }

    private static boolean isOneInsertionAway(String str1, String str2) {
        if (str1.length() != str2.length() - 1) {
            return false;
        }
        boolean oneInsertion = false;
        int i = 0;
        int j = 0;
        while (i < str1.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (oneInsertion) {
                    return false;
                } else {
                    oneInsertion = true;
                    j++;
                }
            }
            i++;
            j++;
        }
        return true;
    }

    private static boolean isOneRemovalAway(String str1, String str2) {
        if (str1.length() - 1 != str2.length()) {
            return false;
        }
        boolean oneRemoval = false;
        int i = 0;
        int j = 0;
        while (j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (oneRemoval) {
                    return false;
                } else {
                    oneRemoval = true;
                    i++;
                }
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        // Expected true.
        System.out.println(isOneEditAway("pale", "ple"));
        // Expected true.
        System.out.println(isOneEditAway("pales", "pale"));
        // Expected true.
        System.out.println(isOneEditAway("pale", "bale"));
        // Expected false.
        System.out.println(isOneEditAway("pale", "bae"));
    }
}
