import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        var opened = new LinkedList<Integer>();
        int[] pair = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opened.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = opened.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, d = 1; i < s.length(); i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
