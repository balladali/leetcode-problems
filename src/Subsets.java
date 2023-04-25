import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/subsets
    Algorithm: Backtracking
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void findSubset(List<List<Integer>> result, int i, List<Integer> subset, int[] nums) {
        result.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (!subset.contains(nums[j])) {
                subset.add(nums[j]);
                findSubset(result, j, subset, nums);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
