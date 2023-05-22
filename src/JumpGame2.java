/*
    Link: https://leetcode.com/problems/jump-game-ii
    Algorithm: DP, Greedy
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int curStart = 0;
        int curEnd = 0;
        int curFar = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFar = Math.max(curFar, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFar;
                count++;
            }
        }
        return count;
    }
}
