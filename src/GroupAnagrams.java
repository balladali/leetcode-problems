import java.util.*;

/*
    Link: https://leetcode.com/problems/group-anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String line: strs) {
            char[] charArray = line.toCharArray();
            Arrays.sort(charArray);
            int hashCode = Arrays.hashCode(charArray);
            List<String> list = map.getOrDefault(hashCode, new ArrayList<>());
            list.add(line);
            map.put(hashCode, list);
        }
        return new ArrayList<>(map.values());
    }
}
