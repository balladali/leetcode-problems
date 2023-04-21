/*
    Link: https://leetcode.com/problems/minimum-size-subarray-sum
    Algorithm: Sliding Window
 */
public class MinSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (l <= r && sum >= target) {
                if (sum >= target) {
                    result = Math.min(result, r - l + 1);
                }
                sum -= nums[l++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
