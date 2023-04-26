import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/combination-sum-ii
    Algorithm: Backtracking
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(result, 0, new ArrayList<>(), candidates, target);
        return result;
    }

    private void findCombination(List<List<Integer>> result, int pos, List<Integer> combination, int[] nums, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else if (target > 0) {
            for (int i = pos; i < nums.length; i++) {
                if (nums[i] > target || (i > pos && nums[i - 1] == nums[i])) {
                    continue;
                }
                combination.add(nums[i]);
                findCombination(result, i + 1, combination, nums, target - nums[i]);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
