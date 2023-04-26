import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/combination-sum
    Algorithm: Backtracking
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(result, 0, new ArrayList<>(), candidates, target);
        return result;
    }

    private void findCombination(List<List<Integer>> result, int pos, List<Integer> combination, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            combination.add(candidates[i]);
            findCombination(result, i, combination, candidates, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
