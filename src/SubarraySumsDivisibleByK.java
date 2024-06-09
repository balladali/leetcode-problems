/*
    Link: https://leetcode.com/problems/subarray-sums-divisible-by-k
    Algorithm: Prefix Sum
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        int result = 0;
        int prefixMod = 0;
        for (int i: nums) {
            prefixMod = (prefixMod + i % k + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }
}
