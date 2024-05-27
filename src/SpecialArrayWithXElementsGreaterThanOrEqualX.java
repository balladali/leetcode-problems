import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
    Algorithm: Binary Search
*/
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            int index = searchFirst(nums, i);
            if (nums.length - index == i) {
                return i;
            }
        }
        return -1;
    }

    private int searchFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
