/*
    Link: https://leetcode.com/problems/patching-array/
    Explanation: https://www.youtube.com/watch?v=vmKXw3lgt7I
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        int result = 0;
        long missing = 1;
        int i = 0;
        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i];
                i++;
            } else {
                missing += missing;
                result++;
            }
        }
        return result;
    }
}
