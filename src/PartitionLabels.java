import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/partition-labels
    Algorithm: Two pointers
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int j = 0;
        int anchor = 0;
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                result.add(j - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }
}
