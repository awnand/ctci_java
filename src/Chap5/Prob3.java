package Chap5;

/* Contains methods for the purpose of finding the length of the longest sequence of ones that you
*  can create by flipping a single bit in an integer input. */
public class Prob3 {

    /* This is the brute force solution to this problem.  We scan the input from the least significant
    *  bit to the most significant bit.  Whenever we run into a 0, we create a new number with the same
    *  binary except with that bit set, and then we find the length of the longest sequence of 1's in that
    *  number. If it is greater than that of our current max, then we make that length our new max.  We continue
    *  on with the scan if possible.  If N represents the number of bits of input, this method takes
    *  O(N^2) time since we scan N bits for every 0 in our N-bit input and O(1) space since we hold
    *  a constant amount of data independent of the binary length of the input. */
    public static int findLongestSequence(int input) {
        int msbIndex = BitManipulater.findMostSignificantBitIndex(input);
        int maxCount = 0;
        int currCount;
        for (int i = 0; i <= msbIndex; i++) {
            if (!BitManipulater.getBit(input, i)) {
                currCount = findLongestSequenceHelper(BitManipulater.setBit(input, i), msbIndex);
                maxCount = currCount > maxCount ? currCount : maxCount;
            }
        }
        return maxCount;
    }

    // This method scans the binary of input to find the length of the longest sequence of 1's.
    public static int findLongestSequenceHelper(int input, int msbIndex) {
        int maxCount = 0;
        int currCount = 0;
        for (int i = 0; i <= msbIndex; i++) {
            if (BitManipulater.getBit(input, i)) {
                currCount++;
            } else {
                maxCount = currCount > maxCount ? currCount : maxCount;
                currCount = 0;
            }
        }

        maxCount = currCount > maxCount ? currCount : maxCount;
        return maxCount;
    }

    /* This is a far more efficient way to find the longest potential sequence.  We scan the binary
    *  of the input, but for each 0 that we encounter, we have been keeping track of the number of 1's
    *  that appeared before it, and then we count the 1's that appear after it.  We then add the before 1's
    *  with the after 1's, plus 1 to account for the current zero that would potentially be flipped to find
    *  our sequence length. If the current sequence length is greater than the previous max, then we
    *  replace that max with the current length.  This method takes O(N) time since we only perform constant
    *  operations for each bit in the input, and 0(1) space since we take up no extra space.*/
    public static int findLongestSequence2(int input) {
        // Keeps track of the 1's before the current 0
        int prevCount = 0;
        // Keeps track of the 1's after the current 0
        int afterCount = 0;
        // Keeps track of the max sequence length seen so far.
        int maxSeqLen = 0;
        int currSeqLen;
        int msbIndex = BitManipulater.findMostSignificantBitIndex(input);
        for (int i = 0; i <= msbIndex; i++) {
            if (BitManipulater.getBit(input, i)) {
                afterCount++;
            } else {
                /* Add together 1's before, 1's after, and 1 to account for the previous 0 which would
                *  have been flipped to make the just finished sequence. */
                currSeqLen = prevCount + afterCount + 1;
                maxSeqLen = currSeqLen > maxSeqLen ? currSeqLen : maxSeqLen;
                // We are now focusing on a new 0 bit, whose previous 1's are the previous 0's after 1's.
                prevCount = afterCount;
                afterCount = 0;
            }
        }
        // We need whose max potential sequences end with the most significant bit.
        currSeqLen = prevCount + afterCount + 1;
        maxSeqLen = currSeqLen > maxSeqLen ? currSeqLen : maxSeqLen;
        return maxSeqLen;
    }

    public static void findLongestSequenceAndPrint(int input) {
        System.out.println("Integer input: " + input);
        System.out.println("Binary of Integer Input: " + Integer.toBinaryString(input));
        System.out.println("Longest Possible Sequence of 1's: " + findLongestSequence(input));
        System.out.println("-----------------------");
    }

    public static void findLongestSequenceAndPrint2(int input) {
        System.out.println("Integer input: " + input);
        System.out.println("Binary of Integer Input: " + Integer.toBinaryString(input));
        System.out.println("Longest Possible Sequence of 1's: " + findLongestSequence2(input));
        System.out.println("-----------------------");
    }



    public static void main(String[] args) {
        // Expected 4
        findLongestSequenceAndPrint(14);
        // Expected 8
        findLongestSequenceAndPrint(8138);
        // Expected 4
        findLongestSequenceAndPrint(45392);
        // Expected 5
        findLongestSequenceAndPrint(19642);
        // Expected 5
        findLongestSequenceAndPrint(2397);
        // Expected 4
        findLongestSequenceAndPrint2(14);
        // Expected 8
        findLongestSequenceAndPrint2(8138);
        // Expected 4
        findLongestSequenceAndPrint2(45392);
        // Expected 5
        findLongestSequenceAndPrint2(19642);
        // Expected 5
        findLongestSequenceAndPrint2(2397);

    }
}

