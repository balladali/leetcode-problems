import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/the-number-of-beautiful-subsets
    Algorithm: Backtracking
 */
public class TheNumberOfBeautifulSubsets {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, k, new ArrayList<>(), result);
        return result.size();
    }

    private void helper(int i, int[] nums, int k, List<Integer> subset, List<List<Integer>> result) {
        if (i == nums.length) {
            if (!subset.isEmpty()) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        if (!subset.contains(nums[i] - k)) {
            subset.add(nums[i]);
            helper(i + 1, nums, k, subset, result);
            subset.remove(subset.size() - 1);
        }
        helper(i + 1, nums, k, subset, result);
    }
}
