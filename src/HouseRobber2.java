/*
    Link: https://leetcode.com/problems/house-robber-ii
    Algorithm: DP
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }

    private int dp(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
