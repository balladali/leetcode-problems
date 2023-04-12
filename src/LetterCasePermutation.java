import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/letter-case-permutation
    Algorithm: Backtracking
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        char[] sArray = s.toCharArray();
        List<String> result = new ArrayList<>();
        findPermutation(result, "", 0, sArray);
        return result;
    }

    private void findPermutation(List<String> result, String permutation, int i, char[] sArray) {
        if (i == sArray.length) {
            result.add(permutation);
            return;
        }
        if (sArray[i] >= 65 && sArray[i] <= 90) {
            findPermutation(result, permutation + (char)(sArray[i] + 32), i + 1, sArray);
        } else if (sArray[i] >= 97 && sArray[i] <= 122) {
            findPermutation(result, permutation + (char)(sArray[i] - 32), i + 1, sArray);
        }
        findPermutation(result, permutation + sArray[i], i + 1, sArray);
    }
}
