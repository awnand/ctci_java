package Chap5;

/* Contains methods for the purpose of, given an Integer input, finding the next smallest and next
*  largest number that have the same number of 1 bits in their binary representation. */
public class Prob4 {

    /* This method is the brute force solution to the problem.  First we increment up until we find
    *  an Integer with the same number of 1 bits.  We leverage the built-in method Integer.bitCount.
    *  We then decrement and do the same thing to find the next smallest number with the same number
    *  of 1 bits. This method is straight forward but not super efficient.  We can do better. */
    public static void findNeighborInts(int input) {
        Integer inputBitCount = Integer.bitCount(input);
        System.out.println("Input number: " + input + "(" + Integer.toBinaryString(input) + ")");
        int increment = input + 1;
        while (Integer.bitCount(increment) != inputBitCount) {
            increment++;
        }
        System.out.print("The next largest number with the same amount of 1's in binary: ");
        System.out.print(increment);
        System.out.println(" (" + Integer.toBinaryString(increment) + ")");
        int decrement = input - 1;
        while (Integer.bitCount(decrement) != inputBitCount) {
            decrement--;
        }
        System.out.print("The next smallest number with the same amount of 1's in binary: ");
        System.out.print(decrement);
        System.out.println(" (" + Integer.toBinaryString(decrement) + ")");
    }

    /* This method leverages the helper methods findNextInt and findPrevInt below.  To find out
    *  more about how those methods work, check the comments for the respective functions.  The runtime
    *  of this function is O(N) since our helper methods take that time. We use a constant amount of space. */
    public static void findNeighborInts2(int input) {
        System.out.println("Input number: " + input + "(" + Integer.toBinaryString(input) + ")");
        int next = findNextInt(input);
        System.out.print("The next largest number with the same amount of 1's in binary: ");
        System.out.print(next);
        System.out.println(" (" + Integer.toBinaryString(next) + ")");
        int decrement = findPrevInt(input);
        System.out.print("The next smallest number with the same amount of 1's in binary: ");
        System.out.print(decrement);
        System.out.println(" (" + Integer.toBinaryString(decrement) + ")");
    }

    /* This method finds the next largest integer with the same amount of set bits in binary as the
    *  input.  By scanning the binary string of the input from the least significant bit to the most
    *  significant bit, we can find the first instance of a 1 followed by a 0 (e.g. the first two bits
    *  in the binary 01101.  If we swap those two bits, we have an integer (01110) with the
    *  same amount of set bits that is the next largest value.  If a "01" cannot be found, this must
    *  mean we have a string of all 1's up to the most significant bit (e.g. 11111).  If this is the case,
    *  the next largest number with the same amount of set bits is simply the one with an new added most
    *  significant bit and the rest of the bits filling in from the least significant to the most significant.
    *  For example, if our input was binary 11111, then the output would be 101111.  The runtime for this
    *  method is O(N) where N is the number of bits in the input.  We take a constant amount of space. */
    private static int findNextInt(int input) {
        int msbIndex = BitManipulater.findMostSignificantBitIndex(input);
        for (int i = 0; i < msbIndex; i++) {
            // Search for a "01"
            if (BitManipulater.getBit(input, i) && !BitManipulater.getBit(input, i+1)) {
                return BitManipulater.clearBit(BitManipulater.setBit(input, i+1), i);
            }
        }
        // In the case where we do not run in to a "01", we add a new set most significant bit.
        int mostSigBit = 1 << (msbIndex + 1);
        // Set the rest of the bits starting from the least significant to the most significant.
        int restOfBits = (1 << (Integer.bitCount(input) - 1)) - 1;
        return mostSigBit | restOfBits;
    }

    /* This method finds the next smallest integer with the same amount of set bits in binary as the
     *  input.  By scanning the binary string of the input from the least significant bit to the most
     *  significant bit, we can find the first instance of a 0 followed by a 1 (e.g. the first two bits
     *  in the binary 01110.  If we swap those two bits, we have an integer (01101) with the
     *  same amount of set bits that is the next largest value.  If a "10" cannot be found, this must
     *  mean we have a string of all 1's up to the most significant bit (e.g. 11111).  If this is the case,
     *  the next smallest number with the same amount of set bits is the one where the input is shifted
     *  to the left end as much as possible so that the output is now a negative number.  For example
     *  if our input was binary 11111 then our output would be 11111000...000 where there are a total
     *  of 32 bits. The runtime for this method is O(N) where N is the number of bits in the input.
     *  We take a constant amount of space. */
    private static int findPrevInt(int input) {
        int msbIndex = BitManipulater.findMostSignificantBitIndex(input);
        // Search for "10"
        for (int i = 0; i < msbIndex; i++) {
            if (!BitManipulater.getBit(input, i) && BitManipulater.getBit(input, i+1)) {
                return BitManipulater.clearBit(BitManipulater.setBit(input, i), i+1);
            }
        }
        /* In the case we do not run into a "10", return the negative number that has the same amount
        *  of set bits. */
        return input << (32 - (msbIndex + 1));
    }

    public static void main(String[] args) {
        // Expected 47 and -134217728.
        findNeighborInts(31);
        // Expected 19 and 13.
        findNeighborInts(14);
        // Expected 8140 and 8137.
        findNeighborInts(8138);
        // Expected 45408 and 45384.
        findNeighborInts(45392);
        // Expected 19644 and 19641.
        findNeighborInts(19642);
        // Expected 2398 and 2395.
        findNeighborInts(2397);
        System.out.println("-----------------------");
        // Expected 47 and -134217728.
        findNeighborInts2(31);
        // Expected 19 and 13.
        findNeighborInts(14);
        // Expected 8140 and 8137.
        findNeighborInts2(8138);
        // Expected 45408 and 45384.
        findNeighborInts2(45392);
        // Expected 19644 and 19641.
        findNeighborInts2(19642);
        // Expected 2398 and 2395.
        findNeighborInts2(2397);
    }
}
