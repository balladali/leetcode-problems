import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/backspace-string-compare
    Algorithm: Two Pointers, Stack
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int backS = 0;
        int backT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s.charAt(i) == '#' || backS > 0)) {
                backS += (s.charAt(i) == '#') ? 1 : -1;
                i--;
            }
            while (j >= 0 && (t.charAt(j) == '#' || backT > 0)) {
                backT += (t.charAt(j) == '#') ? 1 : -1;
                j--;
            }
            if (i < 0 || j < 0) {
                return i == j;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return i == j;
    }
    public boolean backspaceCompareStack(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        LinkedList<Character> sList = new LinkedList<>();
        LinkedList<Character> tList = new LinkedList<>();
        for (char sChar : sChars) {
            if (sChar != '#') {
                sList.push(sChar);
            } else if (!sList.isEmpty()) {
                sList.poll();
            }
        }
        for (char tChar : tChars) {
            if (tChar != '#') {
                tList.push(tChar);
            } else if (!tList.isEmpty()) {
                tList.poll();
            }
        }
        return sList.equals(tList);
    }
}
