/*
    Link: https://leetcode.com/problems/reverse-words-in-a-string-iii
 */
public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        String[] sArray = s.split(" ");
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = reverseString(sArray[i].toCharArray());
        }
        return String.join(" ", sArray);
    }

    private String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        return new String(s);
    }
}
