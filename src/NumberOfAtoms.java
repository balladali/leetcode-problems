import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/*
    Link: https://leetcode.com/problems/number-of-atoms
 */
public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Map<String, Integer> map = new TreeMap<>();
        var stack = new LinkedList<Integer>();

        StringBuilder digit = new StringBuilder();
        StringBuilder elem = new StringBuilder();
        int multi = 1;
        int curDigit = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (isDigit(c)) {
                digit.append(c);
            }
            if (c == ')') {
                int d = digit.length() == 0 ? 1: Integer.parseInt(digit.reverse().toString());
                multi *= d;
                curDigit = 1;
                digit = new StringBuilder();
                stack.push(d);
            }
            if (c == '(') {
                multi /= stack.pop();
            }
            if (isLowLetter(c)) {
                elem.append(c);
                curDigit = 1;
                if (digit.length() != 0) {
                    curDigit = Integer.parseInt(digit.reverse().toString());
                    digit = new StringBuilder();
                }
            }
            if (isUpperLetter(c)) {
                elem.append(c);
                if (digit.length() != 0) {
                    curDigit = Integer.parseInt(digit.reverse().toString());
                    digit = new StringBuilder();
                }
                String atom = elem.reverse().toString();
                int count = map.getOrDefault(atom, 0);
                map.put(atom, count + curDigit * multi);
                elem = new StringBuilder();
                curDigit = 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() != 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }

    private boolean isUpperLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isLowLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
