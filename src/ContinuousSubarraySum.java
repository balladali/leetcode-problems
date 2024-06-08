import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/continuous-subarray-sum/
    Algorithm: Prefix Sum
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixMod = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;
            if (map.containsKey(prefixMod)) {
                if (i - map.get(prefixMod) >= 2) {
                    return true;
                }
            } else{
                map.put(prefixMod, i);
            }
        }
        return false;
    }
}
