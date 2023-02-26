import java.util.*;

/*
    Link: https://leetcode.com/problems/remove-invalid-parentheses
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int initialLength = s.length();
        int minDeletions = initialLength;
        q.add(s);
        visited.add(s);
        while (!q.isEmpty()) {
            String current = q.poll();
            int currentLength = current.length();
            if (isValid(current)) {
                result.add(current);
                minDeletions = Math.min(minDeletions, initialLength - currentLength);
            }
            for (int i = 0; i < currentLength; i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') {
                    continue;
                }
                String next = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(next) && initialLength - next.length() <= minDeletions) {
                    visited.add(next);
                    q.add(next);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
