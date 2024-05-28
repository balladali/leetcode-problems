/*
    Link: https://leetcode.com/problems/longest-nice-subarray/
    Algorithm: Sliding Window
 */
public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int r = 1;
        int result = 1;
        int current = nums[0];
        while (r < nums.length) {
            while ((current & nums[r]) != 0) {
                current -= nums[l++];
            }
            current += nums[r];
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
