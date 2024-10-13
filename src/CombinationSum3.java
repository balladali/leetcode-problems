import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/combination-sum-iii
    Algorithm: Backtracking
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(k, n, 1, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void backtracking(int k, int n, int digit, int sum, List<Integer> current, List<List<Integer>> result) {
        if (sum == n && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (current.size() > k) {
            return;
        }
        for (int i = digit; i <= 9; i++) {
            current.add(i);
            backtracking(k, n, i + 1, sum + i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
