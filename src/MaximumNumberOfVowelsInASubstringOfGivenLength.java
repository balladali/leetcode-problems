/*
    Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
    Algorithm: Sliding Window
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(sChars[i])) {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(sChars[i - k])) {
                count--;
            }
            if (isVowel(sChars[i])) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
