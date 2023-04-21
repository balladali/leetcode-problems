/*
    Link: https://leetcode.com/problems/subarray-product-less-than-k
    Algorithm: Sliding Window
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int result = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (l <= r && product >= k) {
                product /= nums[l];
                l++;
            }
            result += r - l + 1;
        }
        return result;
    }
}
