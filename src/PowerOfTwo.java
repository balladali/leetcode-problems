/*
    Link: https://leetcode.com/problems/power-of-two
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public boolean isPowerOfTwoLoop(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwoRecursion(int n) {
        if (n == 0) {
            return false;
        }
        return n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2));
    }
}
