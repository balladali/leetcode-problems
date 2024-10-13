/*
    Link: https://leetcode.com/problems/find-peak-element
    Algorithm: Binary Search
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean isLeftLess = mid - 1 < 0 ? true : nums[mid - 1] < nums[mid];
            boolean isRightLess = mid + 1 == nums.length ? true : nums[mid + 1] < nums[mid];
            if (isLeftLess && isRightLess) {
                return mid;
            }
            if (isLeftLess) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    //------------------ Without binary search ----------------------

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isLeftLess = i - 1 < 0 ? true : nums[i - 1] < nums[i];
            boolean isRightLess = i + 1 == nums.length ? true : nums[i + 1] < nums[i];
            if (isLeftLess && isRightLess) {
                return i;
            }
        }
        return -1;
    }
}
