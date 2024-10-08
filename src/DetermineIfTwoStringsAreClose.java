import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/determine-if-two-strings-are-close
 */
public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < n; i++) {
            a1[word1.charAt(i) - 'a']++;
            a2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a1[i] == a2[i]) {
                continue;
            }
            if (a1[i] == 0 || a2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
