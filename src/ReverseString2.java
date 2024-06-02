/*
    Link: https://leetcode.com/problems/reverse-string-ii/
    Algorithm: Two pointers
 */
public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int count = 0;
        while (count < arr.length) {
            int l = count;
            int r = Math.min(l + k - 1, arr.length - 1);
            while (l < r) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
            count += 2 * k;
        }
        return new String(arr);
    }
}
