import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/permutations-ii
    Algorithm: Backtracking
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            findPermutations(result, i, new ArrayList<>(), used, nums);
        }
        return result;
    }

    private void findPermutations(List<List<Integer>> result, int i, List<Integer> permutation, boolean[] used, int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j] || (j > 0 && nums[j - 1] == nums[j] && !used[j - 1])) {
                continue;
            }
            permutation.add(nums[j]);
            used[j] = true;
            findPermutations(result, j, permutation, used, nums);
            used[j] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
