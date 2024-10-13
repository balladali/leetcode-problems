import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
    Algorithm: Backtracking, DFS
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        dfs(digits, mapping, 0, "", result);
        return result;
    }

    private void dfs(String digits, String[] mapping, int index, String path, List<String> result) {
        if (index >= digits.length()) {
            result.add(path);
            return;
        }
        int pos = Character.getNumericValue(digits.charAt(index));
        for (Character c: mapping[pos].toCharArray()) {
            dfs(digits, mapping, index + 1, path + c, result);
        }
    }

    //---------------------- Backtracking -----------------------

    public List<String> letterCombinations2(String digits) {
        Map<Character, List<Character>> keys = initKeyboard();
        List<String> result = new ArrayList<>();
        backtracking(0, digits, new StringBuilder(), keys, result);
        return result;
    }

    private void backtracking(int i, String digits, StringBuilder s, Map<Character, List<Character>> keys, List<String> result) {
        if (s.length() == digits.length()) {
            if (s.length() != 0) {
                result.add(s.toString());
            }
            return;
        }
        char c = digits.charAt(i);
        for (char keyChar: keys.get(c)) {
            s = s.append(keyChar);
            backtracking(i + 1, digits, s, keys, result);
            s = s.deleteCharAt(s.length() - 1);
        }
    }

    private Map<Character, List<Character>> initKeyboard() {
        Map<Character, List<Character>> keys = new HashMap<>();
        keys.put('2', List.of('a', 'b', 'c'));
        keys.put('3', List.of('d', 'e', 'f'));
        keys.put('4', List.of('g', 'h', 'i'));
        keys.put('5', List.of('j', 'k', 'l'));
        keys.put('6', List.of('m', 'n', 'o'));
        keys.put('7', List.of('p', 'q', 'r', 's'));
        keys.put('8', List.of('t', 'u', 'v'));
        keys.put('9', List.of('w', 'x', 'y', 'z'));
        return keys;
    }
}
