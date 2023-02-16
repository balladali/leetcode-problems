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
}
