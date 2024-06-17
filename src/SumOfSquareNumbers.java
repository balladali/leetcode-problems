/*
    Link: https://leetcode.com/problems/sum-of-square-numbers/
    Algorithm: Two Pointers, Binary Search
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long square = l * l + r * r;
            if (square == c) {
                return true;
            }
            if (square > c) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }
}
