package Chap5;


// Contains methods for the purpose of converting a decimal number into a binary String.
public class Prob2 {
    /* Notice that in binary, multiplying a number by 2, is analogous to multiplying by 10 in decimal,
    *  in that it shifts over the number by a digit.  Since we are given a decimal that is in between
    *  0 and 1, we can iteratively do the following: multiply the current number by 2 to shift over
    *  the binary representation by 1, check to see if the resulting number is greater than or equal
    *  to 1, if it is, we know that bit we are checking is set and we subtract by 1 to reset for the
    *  next iteration, otherwise we know the next bit is not set and we simply place a 0.  O(N) time
    *  is required to go through each bit and O(N) space is required to build our new String.*/
    public static String convertToBinaryString(float decimal) {
        if (decimal >= 1 || decimal < 0) {
            return "ERROR";
        }
        StringBuilder build = new StringBuilder(32);
        build.append(".");
        float curr = decimal * 2;
        while (curr > 0.0) {
            // We limit the representation to 32 bits, which would be 33 characters including the dot.
            if (build.length() > 33) {
                return "ERROR";
            }
            if (curr >= 1) {
                build.append(1);
                curr = curr - 1;
            } else {
                build.append(0);
            }
            curr = curr * 2;
        }
        return build.toString();
    }

    /* Given a binary String, this method converts the input in the floating number it represents.
    *  This function is meant to be used to test output from covertToBinaryString.  Notice that if
    *  convertToDecimal is given an "ERROR" String from convertToBinaryString, it will output 0.0.*/
    public static float convertToDecimal(String binary) {
        float decimal = 0.0f;
        for (int i = 1; i < binary.length(); i++) {
            int powerBit = binary.charAt(i) == '1' ? 1: 0;
            float powerOf2 =  (1.0f/ (2 << (i - 1)));
            float fraction = powerBit * powerOf2;
            decimal += fraction;
        }
        return decimal;
    }

    /* This function converts a floating number to a binary String, and then converts that binary
    *  String back to a floating number to check that the binary String was correct.  We use this
    *  function for testing of convertToBinaryString. If the first printed floating number does not
    *  match the last, we have to check convertToBinaryString to see what is wrong. */
    private static void convertAndPrint(float decimal) {
        System.out.println("Original floating number: " + decimal);
        String binaryString = convertToBinaryString(decimal);
        System.out.println("Binary Conversion: " + binaryString);
        System.out.println("Binary String Converted Back to Decimal: " + convertToDecimal(binaryString));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        /* For all, expected 'Original floating number' to be equivalent to 'Binary String Converted
        *  Back to Decimal */
        convertAndPrint(0.72f);
        convertAndPrint(0.95f);
        convertAndPrint(0.36f);
        convertAndPrint(0.86f);
        convertAndPrint(0.19f);
        convertAndPrint(0.32f);
        convertAndPrint(0.78f);
        convertAndPrint(0.85f);
        convertAndPrint(0.21f);
    }
}
