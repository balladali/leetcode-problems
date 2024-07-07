import java.util.*;

/*
    Link: https://leetcode.com/problems/top-k-frequent-words
    Algorithm: Sorting, Priority Queue
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsMap = new TreeMap<>();
        for (String word: words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((x, y) -> x.getValue() == y.getValue() ? y.getKey().compareTo(x.getKey()) : x.getValue() - y.getValue());
        for (Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            result.add(0, queue.poll().getKey());
        }
        return result;
    }
}
