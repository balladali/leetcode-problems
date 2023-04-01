/*
    Link: https://leetcode.com/problems/squares-of-a-sorted-array
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        int left = 0;
        int right = index;
        while (index >= 0) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            if (leftValue >= rightValue) {
                result[index--] = leftValue;
                left++;
            } else {
                result[index--] = rightValue;
                right--;
            }
        }
        return result;
    }
}
