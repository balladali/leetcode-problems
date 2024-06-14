import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/minimum-increment-to-make-array-unique
 */
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[nums.length + max];
        for (int num: nums) {
            counts[num]++;
        }
        int result = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] <= 1) {
                continue;
            }
            int duplicates = counts[i] - 1;
            counts[i + 1] += duplicates;
            result += duplicates;
        }
        return result;
    }

    // ---------- Sorting ------------

    public int minIncrementForUnique2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            int duplicates = nums[i - 1] + 1 - nums[i];
            result += duplicates;
            nums[i] = nums[i - 1] + 1;
        }
        return result;
    }
}
