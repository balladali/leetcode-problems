import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/palindrome-partitioning
    Algorithm: Backtracking
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>());
        return result;
    }

    private void helper(String s, List<List<String>> result, List<String> step) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (!isPalindrome(sub)) {
                continue;
            }
            step.add(sub);
            helper(s.substring(i), result, step);
            step.remove(step.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
