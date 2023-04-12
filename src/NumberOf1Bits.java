/*
    Link: https://leetcode.com/problems/number-of-1-bits
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
