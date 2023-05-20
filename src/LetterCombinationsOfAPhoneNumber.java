import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
    Algorithm: Backtracking, DFS
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfs(digits, mapping, 0, "", result);
        return result;
    }

    private void dfs(String digits, String[] mapping, int index, String path, List<String> result) {
        if (index >= digits.length()) {
            result.add(path);
            return;
        }
        int pos = Character.getNumericValue(digits.charAt(index));
        for (Character c: mapping[pos].toCharArray()) {
            dfs(digits, mapping, index + 1, path + c, result);
        }
    }
}
