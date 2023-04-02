/*
    Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {++left, ++right};
    }
}
