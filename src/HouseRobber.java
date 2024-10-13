/*
    Link: https://leetcode.com/problems/house-robber
    Algorithm: Dynamic programming, memoization
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        nums[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 3], nums[i - 2]);
        }
        return Math.max(nums[n - 1], nums[n - 2]);
    }

    // --------------------- DP -----------------------

    public int robDp(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
