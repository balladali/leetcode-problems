/*
    Link: https://leetcode.com/problems/reverse-words-in-a-string
    Algorithm: Two pointers
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            String tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        StringBuilder sBuilder = new StringBuilder();
        for (String word: arr) {
            if (!"".equals(word)) {
                sBuilder.append(word).append(" ");
            }
        }
        return sBuilder.substring(0, sBuilder.length() - 1);
    }
}
