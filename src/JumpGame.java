/*
    Link: https://leetcode.com/problems/jump-game
    Algorithm: DP
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int reachableIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachableIndex) {
                return false;
            }
            reachableIndex = Math.max(reachableIndex, i + nums[i]);
        }
        return true;
    }
}
