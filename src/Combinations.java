import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/combinations
    Algorithm: Backtracking
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            findCombinations(result, i, new ArrayList<>(), k, n);
        }
        return result;
    }

    private void findCombinations(List<List<Integer>> result, int current, List<Integer> combination, int k, int n) {
        combination.add(current);
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
        }
        for (int i = current + 1; i <= n; i++) {
            findCombinations(result, i, combination, k, n);
        }
        combination.remove(combination.size() - 1);
    }

//    --------------------------------
    public List<List<Integer>> combineAnother(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsAnother(result, nums, new ArrayList<>(), k, 0);
        return result;
    }

    private void findCombinationsAnother(List<List<Integer>> result, List<Integer> nums, List<Integer> combination, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            if (combination.contains(nums.get(i)) || (combination.size() > 0 && nums.get(i) < combination.get(combination.size() - 1))) {
                continue;
            }
            combination.add(nums.get(i));
            findCombinationsAnother(result, nums, combination, remain - 1, start + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
