import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> parentheses = new LinkedList<>();
        for (char symbol: s.toCharArray()) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                parentheses.push(symbol);
            } else {
                if (parentheses.isEmpty()) {
                    return false;
                }
                char last = parentheses.pop();
                switch (symbol) {
                    case ')':
                        if (last != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (last != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (last != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
        return parentheses.isEmpty();
    }
}
