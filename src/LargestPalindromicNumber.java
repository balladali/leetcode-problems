public class LargestPalindromicNumber {
    public static String largestPalindromic(String num) {
        int[] arr = new int[10];
        for (char c : num.toCharArray()) {
            arr[c - '0']++;
        }
        int singlePosition = -1;
        StringBuffer ans = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            if (ans.length() == 0 && i == 0) {
                continue;
            }
            while (arr[i] > 1) {
                ans.append((char)(i + '0'));
                arr[i] -= 2;
            }
            if (arr[i] == 1 && singlePosition == -1) {
                singlePosition = i;
            }
        }
        if (ans.length() == 0 && singlePosition == -1) {
            return "0";
        }
        int i = ans.length() - 1;
        if (singlePosition != -1) {
            ans.append((char)(singlePosition + '0'));
        }
        while (i >= 0) {
            ans.append(ans.charAt(i--));
        }
        return ans.toString();
    }
}
