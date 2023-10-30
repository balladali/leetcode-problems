/*
    Link: https://leetcode.com/problems/one-edit-distance
 */
public class OneEditDistance {
    private boolean isEditDistanceOne(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) {
                    return false;
                }
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            } else {
                i++;
                j++;
            }
        }
        if (i < m || j < n) {
            count++;
        }
        return count == 1;
    }

}
