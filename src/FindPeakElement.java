/*
    Link: https://leetcode.com/problems/find-peak-element
    Algorithm: Binary Search
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midElem = nums[mid];
            int leftElem = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightElem = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid + 1];
            if (midElem > leftElem && midElem > rightElem) {
                return mid;
            }
            if (leftElem > rightElem) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
