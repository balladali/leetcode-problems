/*
    Link: https://leetcode.com/problems/search-in-rotated-sorted-array
    Algorithm: Binary Search
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int midElem = nums[mid];
            if (midElem == target) {
                return mid;
            }
            if (midElem >= nums[left]) {
                // left part is sorted
                if (target >= nums[left] && target < midElem) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right part is sorted
                if (target <= nums[right] && target > midElem) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
