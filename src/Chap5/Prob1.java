package Chap5;

/* Contains methods for the purpose of, given two 32-bit numbers N and M, and two bit positions
*  i and j, inserting M into N such that M starts at bit j and ends at bit i.  You can assume that
*  bits j through i have enough space to fit all of M. */
public class Prob1 {

    /* In order to insert M in N, we shift M over by i, so that the least significant bit of M is now
    *  shifted to the correct place where it needs to be inserted in N.  We need not worry about j since
    *  we are guaranteed that there is enough space between i and j to fit all of M.  At this point we
    *  do a bit-wise OR to transfer the bits from M to N.*/

    /* In order to insert M in N, we have to first clear the bits i through j in N, so that we can
    *  simply shift M and then perform an OR operation to combine the bits together.  We start by
    *  taking 2 to the power of (j - i + 1) and subtracting by 1 so we have a sequence of 1's which
    *  has a length of exactly j - i.  We then shift this value over by i and then flip the bits so that
    *  we have all 1's except in the exactly area where M will need to be inserted in N.  We then perform
    *  an AND operation with N so that every bit that was 1 stays the same, except within the area that
    *  needs to be replaced by M.  We then shift M by i to get all of the bits in the right place and
    *  perform our final OR operation. */
    public static int insertMinN(int N, int M, int i, int j) {
        int mask = (2 << (j - i + 1)) - 1;
        mask = ~(mask << i);
        N = N & mask;
        int shiftedM = M << i;
        return N | shiftedM;
    }

    public static void main(String[] args) {
        // Expected 10000001001100.
        System.out.println(Integer.toBinaryString(insertMinN(0b10000001111100, 0b10011, 2, 6)));
    }

}
