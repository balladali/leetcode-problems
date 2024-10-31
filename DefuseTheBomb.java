/*
    Link: https://leetcode.com/problems/defuse-the-bomb
    Algorithm: Sliding Window
 */
public class DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }

        int n = code.length;
        int sum = 0;
        int kAbs = Math.abs(k);
        int start = k > 0 ? 1 : n - kAbs;
        int end = k > 0 ? k : n - 1;

        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum += code[++end % n] - code[start++ % n];
        }
        return result;
    }
}
