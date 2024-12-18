/*
    Link: https://leetcode.com/problems/guess-number-higher-or-lower
    Algorithm: Binary Search
 */

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess == -1) {
                right = mid - 1;
            }
            if (guess == 1) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        // To implement
        return 0;
    }
}