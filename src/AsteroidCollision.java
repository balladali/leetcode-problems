import java.util.Stack;

/*
    Link: https://leetcode.com/problems/asteroid-collision
    Algorithm: Stack
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur: asteroids) {
            int prev = stack.isEmpty() ? 0 : stack.peek();
            while (cur < 0 && prev > 0) {
                if (Math.abs(cur) == Math.abs(prev)) {
                    stack.pop();
                    break;
                }
                if (Math.abs(cur) > Math.abs(prev)) {
                    stack.pop();
                    prev = stack.isEmpty() ? 0 : stack.peek();
                } else {
                    break;
                }
            }
            if (cur > 0 || prev <= 0) {
                stack.push(cur);
            }
        }
        int[] result = new int[stack.size()];
        int i = 0;
        for (int a: stack) {
            result[i++] = a;
        }
        return result;
    }
}
