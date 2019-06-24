package Chap1;

public class Prob1_9 {

    public static boolean isRotation(String str1, String str2) {
        int length = str1.length();
        if (length == str2.length() && length > 0) {
            String str3 = str1 + str1;
            return str3.contains(str2);
        }
        return false;
    }

    public static void main(String[] args) {
        String str1_1 = "waterbottle";
        String str2_1 = "erbottlewat";
        String str1_2 = "waterbottle";
        String str2_2 = "bottleretaw";
        // Expected true
        System.out.println(isRotation(str1_1, str2_1));
        // Expected false
        System.out.println(isRotation(str1_2, str2_2));
    }
}
