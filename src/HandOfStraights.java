import java.util.Map;
import java.util.TreeMap;

/*
    Link: https://leetcode.com/problems/hand-of-straights
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i: hand) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        while (!map.isEmpty()) {
            int current = map.entrySet().iterator().next().getKey();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(current + i)) {
                    return false;
                }
                int nextCount = map.get(current + i) - 1;
                if (nextCount == 0) {
                    map.remove(current + i);
                } else {
                    map.put(current + i, nextCount);
                }
            }
        }
        return true;
    }
}
