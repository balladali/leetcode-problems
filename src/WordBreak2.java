import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/word-break-ii
    Algorithm: Backtracking
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        helper(s, wordDict, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, List<String> wordDict, List<String> current, List<String> res) {
        if (s.isEmpty()) {
            res.add(String.join(" ", current));
            return;
        }
        for (String word: wordDict) {
            if (s.startsWith(word)) {
                current.add(word);
                helper(s.substring(word.length()), wordDict, current, res);
                current.remove(current.size() - 1);
            }
        }
    }
}
