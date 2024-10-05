import java.util.Stack;

/*
    Link: https://leetcode.com/problems/removing-stars-from-a-string
    Algorithm: Stack
 */
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sB = new StringBuilder();
        for (char c: stack) {
            sB.append(c);
        }
        return sB.toString();
    }
}
