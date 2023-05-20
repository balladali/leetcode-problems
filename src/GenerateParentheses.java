import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/generate-parentheses
    Algorithm: Backtracking
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, "", 0, 0, result);
        return result;
    }

    private void dfs(int n, String path, int opened, int closed, List<String> result) {
        if (opened == closed && opened == n) {
            result.add(path);
            return;
        }
        if (opened < n) {
            dfs(n, path + '(', opened + 1, closed, result);
        }
        if (opened > closed) {
            dfs(n, path + ')', opened, closed + 1, result);
        }
    }
}
