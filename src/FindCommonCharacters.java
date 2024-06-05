import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/find-common-characters
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] commonCharactersCount = new int[26];
        for (char c: words[0].toCharArray()) {
            commonCharactersCount[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] currentCharactersCount = new int[26];
            for (char c: words[i].toCharArray()) {
                currentCharactersCount[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                commonCharactersCount[j] = Math.min(commonCharactersCount[j], currentCharactersCount[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < commonCharactersCount[i]; k++) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }
}
