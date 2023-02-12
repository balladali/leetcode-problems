/*
    Link: https://leetcode.com/problems/search-in-rotated-sorted-array
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
            if (target < midElem) {
                if (target < nums[left]) {
                    if (nums[left] > midElem) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[right]) {
                    if (nums[right] < midElem) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
