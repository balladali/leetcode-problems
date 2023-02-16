import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagramHash(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char symbol: s.toCharArray()) {
            int count = map.getOrDefault(symbol, 0) + 1;
            map.put(symbol, count);
        }
        for (char symbol: t.toCharArray()) {
            if (map.get(symbol) == null) {
                return false;
            }
            int count = map.get(symbol);
            if (count == 1) {
                map.remove(symbol);
            } else {
                map.put(symbol, --count);
            }
        }
        return map.isEmpty();
    }
}
