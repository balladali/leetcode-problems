import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/permutations
    Algorithm: Backtracking
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i: nums) {
            findPermutations(result, i, new ArrayList<>(), nums);
        }
        return result;
    }

    private void findPermutations(List<List<Integer>> result, int current, List<Integer> permutation, int[] nums) {
        permutation.add(current);
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i])) {
                continue;
            }
            findPermutations(result, nums[i], permutation, nums);
        }
        permutation.remove(permutation.size() - 1);
    }
}
