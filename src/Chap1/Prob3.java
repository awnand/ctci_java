package Chap1;

public class Prob3 {
    public static void urlify(char[] strChars, int trueLength) {
        int spaceCounts = 0;
        for (int i = 0; i < trueLength; i++) {
            if (strChars[i] == ' ') {
                spaceCounts++;
            }
        }
        int index = trueLength + spaceCounts * 2;


        for (int i = trueLength - 1; i >= 0; i--) {
            char character = strChars[i];
            if (character == ' ') {
                strChars[index - 1] = '0';
                strChars[index - 2] = '2';
                strChars[index - 3] = '%';
                index = index - 3;
            } else {
                strChars[index - 1] = strChars[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        char str[] = "Mr John Smith    ".toCharArray();
        urlify(str, 13);
        System.out.println(String.valueOf(str));
    }
}
