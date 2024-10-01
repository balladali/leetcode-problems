/*
    Link: https://leetcode.com/problems/increasing-triplet-subsequence
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= smallest) {
                smallest = num;
                continue;
            }
            if (num <= secondSmallest) {
                secondSmallest = num;
                continue;
            }
            return true;
        }
        return false;
    }
}
