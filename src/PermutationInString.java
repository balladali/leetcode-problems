import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/permutation-in-string
    Algorithm: Sliding Windos
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for (char c: s1.toCharArray()) {
            map[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int needToFind = s1.length();
        while (right < s2.length()) {
            if (map[s2.charAt(right++) - 'a']-- > 0) {
                needToFind--;
            }
            if (needToFind == 0) {
                return true;
            }
            if (right - left == s1.length() && map[s2.charAt(left++) - 'a']++ >= 0) {
                needToFind++;
            }
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            s1Map.put(c1, s1Map.getOrDefault(c1, 0) + 1);
            s2Map.put(c2, s2Map.getOrDefault(c2, 0) + 1);
        }
        if (s1Map.equals(s2Map)) {
            return true;
        }
        int left = 0;
        int right = s1.length();
        while (right < s2.length()) {
            char leftC = s2.charAt(left);
            int count = s2Map.get(leftC) - 1;
            if (count == 0) {
                s2Map.remove(leftC);
            } else {
                s2Map.put(leftC, count);
            }
            char rightC = s2.charAt(right);
            s2Map.put(rightC, s2Map.getOrDefault(rightC, 0) + 1);
            if (s1Map.equals(s2Map)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
