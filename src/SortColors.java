/*
    Link: https://leetcode.com/problems/sort-colors
    Algorithm: Sorting
 */
public class SortColors {

    // ------------- QuickSort ---------------
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int q = partition(nums, l, r);
            quickSort(nums, l, q - 1);
            quickSort(nums, q + 1, r);
        }
    }

    int partition(int[] nums, int l, int r) {
        int x = nums[r];
        int less = l;
        for (int i = l; i < r; i++) {
            if (nums[i] <= x) {
                swap(nums, i, less);
                less++;
            }
        }
        swap(nums, less, r);
        return less;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // ------------- BubbleSort ---------------

    public void sortColors1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] >= nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    // ----------- Counters ------------------
    public void sortColors2(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else if (num == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        int idx = 0;
        for (int i = 0; i < zeros; i++) {
            nums[idx++] = 0;
        }
        for (int i = 0; i < ones; i++) {
            nums[idx++] = 1;
        }
        for (int i = 0; i < twos; i++) {
            nums[idx++] = 2;
        }
    }
}
