/*
    Link: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
    Algorithm: Sliding Window
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int max = 0;
        int k = 1;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[l] == 0) {
                    k++;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max - 1;
    }
}
