/*
    Link: https://leetcode.com/problems/separate-black-and-white-balls
    Algorithm: Two Pointers
 */
public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        long answer = 0;
        while (l < r) {
            if (chars[l] == '1') {
                if (chars[r] == '0') {
                    answer += r - l;
                    l++;
                }
                r--;
            } else {
                if (chars[r] == '1') {
                    r--;
                }
                l++;
            }
        }
        return answer;
    }
}
