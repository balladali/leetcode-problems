import java.util.HashSet;
import java.util.Set;

/*
    Link: https://leetcode.com/problems/longest-palindrome
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        int size = set.size();
        return s.length() - (size > 0 ? size - 1: size);
    }
}
