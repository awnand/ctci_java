package Chap1;

public class Prob6 {

    public static String compress(String str) {
        if (str.equals("")) {
            return str;
        }
        String compressed = "";
        char streakChar = str.charAt(0);
        int streakCharCount = 1;
        for (int i = 1; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (currChar == streakChar) {
                streakCharCount++;
            } else {
                compressed += streakChar + String.valueOf(streakCharCount);
                streakChar = currChar;
                streakCharCount = 1;
            }

            if (i == str.length() - 1) {
                compressed += streakChar + String.valueOf(streakCharCount);
            }
        }
        if (str.length() > compressed.length()) {
            return compressed;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}
