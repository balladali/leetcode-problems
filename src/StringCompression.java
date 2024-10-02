/*
    Link: https://leetcode.com/problems/string-compression
    Algorithm: Two pointers
 */
public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int pos = 0;
        int l = 0;
        int r = 1;
        while (l < n) {
            int count = 1;
            while (r < n && chars[l] == chars[r]) {
                count++;
                r++;
            }
            chars[pos++] = chars[l++];
            if (count > 1) {
                char[] countString = String.valueOf(count).toCharArray();
                for (int i = 0; i < countString.length; i++) {
                    chars[pos] = countString[i];
                    pos++;
                }
            }
            l = r;
            r++;
        }
        return pos;
    }
}
