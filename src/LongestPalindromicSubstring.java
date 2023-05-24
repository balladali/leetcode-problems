/*
    Link: https://leetcode.com/problems/longest-palindromic-substring
    Algorithm: DP
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] sArray = s.toCharArray();
        int palindromeStart = 0;
        int palindromeEnd = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = sArray[i] == sArray[j] && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > palindromeEnd - palindromeStart) {
                    palindromeStart = i;
                    palindromeEnd = j;
                }
            }
        }
        return s.substring(palindromeStart, palindromeEnd + 1);
    }
}
