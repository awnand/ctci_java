package Chap5;

// Contains methods to explain what the code ((n & (n - 1)) == 0).
public class Prob5 {

    public static void main(String[] args) {
        String ans = "Let us start by breaking down the code ((n & (n - 1)) == 0).  If A & B == 0, " +
                "that means the binary form of A and B share no 1's in common amongst their bits.  " +
                "When is this the case?  Notice that when we have a power of 2, the binary has a single " +
                "bit set (e.g. 0100 for 4).  If we subtract 1 from a power of 2, all the bits before " +
                "the set bit of the power of 2 will now be set, with the previously set bit being unset." +
                "For example, if we are given 4 (0100), 3 has the binary form 0011.  Therefore the code " +
                "above checks that n is a power of 2.  It can also check that n is 0, since 0 - 1 = -1, " +
                "which is 111111....11110.";
        System.out.println(ans);
    }
}
