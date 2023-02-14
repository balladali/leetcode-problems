/*
    Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private boolean search(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int midElem = nums[mid];
        if (midElem == target) {
            return true;
        }
        if (midElem >= nums[left]) {
            if (nums[left] == midElem) {
                return search(nums, target, left, mid - 1) || search(nums, target, mid + 1, right);
            }
            if (target >= nums[left] && target < midElem) {
                return search(nums, target, left, mid - 1);
            } else {
                return search(nums, target, mid + 1, right);
            }
        } else {
            if (nums[right] == midElem) {
                return search(nums, target, left, mid - 1) || search(nums, target, mid + 1, right);
            }
            if (target <= nums[right] && target > midElem) {
                return search(nums, target, mid + 1, right);
            } else {
                return search(nums, target, left, mid - 1);
            }
        }
    }
}
