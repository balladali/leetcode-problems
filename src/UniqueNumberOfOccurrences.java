import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Link: https://leetcode.com/problems/unique-number-of-occurrences
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (!set.add(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
