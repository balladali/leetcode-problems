import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/fruit-into-baskets/
    Algorithm: Sliding Window
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int result = 0;
        while (r < fruits.length) {
            while (map.size() > 2) {
                int count = map.get(fruits[l]) - 1;
                if (count == 0) {
                    map.remove(fruits[l]);
                } else {
                    map.put(fruits[l], count);
                }
                l++;
            }
            int count = map.getOrDefault(fruits[r], 0) + 1;
            map.put(fruits[r], count);
            if (map.size() <= 2) {
                result = Math.max(result, r - l + 1);
            }
            r++;
        }
        return result;
    }
}
