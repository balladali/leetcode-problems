/*
    Link: https://leetcode.com/problems/max-consecutive-ones-iii
    Algorithm: Sliding Window
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[l] == 0) {
                    k++;
                }
                l++;
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }
}
