/*
    Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
    Algorithm: Bit manipulation
 */
public class MinimumFlipsToMakeAOrBEqualToC {
    public int minFlips(int a, int b, int c) {
        int aBitsCount = countBits(a);
        int bBitsCount = countBits(b);
        int cBitsCount = countBits(c);
        int maxBits = Math.max(aBitsCount, Math.max(bBitsCount, cBitsCount));
        int count = 0;
        for (int i = 0; i < maxBits; i++) {
            if (isBitSet(c, i)) {
                if (!isBitSet(a, i) && !isBitSet(b, i)) {
                    count++;
                }
            } else {
                if (isBitSet(a, i)) {
                    count++;
                }
                if (isBitSet(b, i)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isBitSet(int a, int index) {
        return (a & (1 << index)) != 0;
    }

    public static int countBits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number >>= 1;
        }
        return count;
    }

    // a 8 1000
    // b 3 0011
    // c 5 0101
}
