import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/subsets-ii
    Algorithm: Backtracking
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(result, 0, new ArrayList<>(), nums);
        return result;
    }

    private void findSubsets(List<List<Integer>> result, int i, List<Integer> subset, int[] nums) {
        result.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            findSubsets(result, j + 1, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
