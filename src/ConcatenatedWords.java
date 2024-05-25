import java.util.*;

/*
    Link: https://leetcode.com/problems/concatenated-words/
    Algorithm: DP
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> allowedWords = new HashSet<>();
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        for (String word: words) {
            if (check(word, allowedWords)) {
                result.add(word);
            }
            allowedWords.add(word);
        }
        return result;
    }

    private boolean check(String s, Set<String> words) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
