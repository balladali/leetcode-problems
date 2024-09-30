/*
    Link: https://leetcode.com/problems/merge-strings-alternately
    Algorithm: Two Pointers
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i != word1.length()) {
                result.append(word1.charAt(i));
                i++;
            }
            if (j != word2.length()) {
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
}
