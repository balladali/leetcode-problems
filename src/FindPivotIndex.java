/*
    Link: https://leetcode.com/problems/find-pivot-index
    Algorithm: Prefix Sum
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int current = nums[0];
        leftSum[0] = current;
        for (int i = 1; i < n; i++) {
            current += nums[i];
            leftSum[i] = current;
        }

        current = nums[n - 1];
        rightSum[n - 1] = current;
        for (int i = n - 2; i >= 0; i--) {
            current += nums[i];
            rightSum[i] = current;
        }

        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
