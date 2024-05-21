import java.util.HashMap;

/*
    Link: https://leetcode.com/problems/isomorphic-strings
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        var sChars = new HashMap<Character, Character>();
        var tChars = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            var sProjection = sChars.get(s.charAt(i));
            var tProjection = tChars.get(t.charAt(i));

            if (sProjection == null && tProjection == null) {
                sChars.put(s.charAt(i), t.charAt(i));
                tChars.put(t.charAt(i), s.charAt(i));
                continue;
            }

            if (sProjection == null || tProjection == null) {
                return false;
            }

            if (sProjection != t.charAt(i) || tProjection != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
