/*
    Link: https://leetcode.com/problems/get-equal-substrings-within-budget/
    Algorithm: Sliding Window
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int r = 0;
        int result = 0;
        int current = 0;
        while (l <= r && r < s.length()) {
            current += Math.abs(s.charAt(r) - t.charAt(r));
            if (current <= maxCost) {
                result = Math.max(result, r - l + 1);
            }
            while (current > maxCost) {
                current -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(1 & 3 & 8 & 48);
    }
}
