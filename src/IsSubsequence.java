/*
    Link: https://leetcode.com/problems/is-subsequence/
    Algorithm: Two pointers
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sP = 0;
        int tP = 0;
        while (sP != s.length() && tP != t.length()) {
            if (s.charAt(sP) == t.charAt(tP)) {
                sP++;
            }
            tP++;
        }
        return sP == s.length();
    }
}
