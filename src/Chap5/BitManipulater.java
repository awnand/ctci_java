package Chap5;

// Helper bit-manipulating methods provided in Chapter 5 of CTCI.
public class BitManipulater {

    // Returns the i-th bit of num.
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i))) != 0;
    }

    // Sets the i-th bit of num to 1.
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    // Clears the i-th bit of num to 0.
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    // Clears all bits from the most significant bit through i (inclusive).
    public static int clearBitMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    // Clears all bits from i through 0 (inclusive).
    public static int clearBitsIthrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    // Updates the i-th bit to 1 or 0 depending on the value of bitIs1.
    public static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static int findMostSignificantBitIndex(int input) {
        return Integer.toBinaryString(input).length() - 1;
    }
}
