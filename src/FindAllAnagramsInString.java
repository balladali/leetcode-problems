import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        int pLength = pArray.length;
        int hash = Arrays.hashCode(pArray);
        for (int i = 0; i < s.length() - pLength + 1; i++) {
            char[] array = s.substring(i, i + pLength).toCharArray();
            Arrays.sort(array);
            if (hash == Arrays.hashCode(array)) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findAnagramsGood(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pArray = new int[28];
        for (char c : p.toCharArray()) {
            pArray[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            pArray[c - 'a']--;
            while (pArray[c - 'a'] < 0) {
                pArray[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()) {
                result.add(left);
            }
            right++;
        }
        return result;
    }
}
