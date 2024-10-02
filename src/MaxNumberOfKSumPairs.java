import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/
    Algorithm: Two pointers, Binary Search
 */
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == k) {
                count++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
