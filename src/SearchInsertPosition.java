/*
    Link: https://leetcode.com/problems/search-insert-position
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int startI = 0;
        int endI = nums.length - 1;
        while (startI <= endI) {
            int midI = startI + (endI - startI) / 2;
            if (nums[midI] == target) {
                return midI;
            }
            if (nums[midI] < target) {
                startI = midI + 1;
            } else {
                endI = midI - 1;
            }
        }
        return startI;
    }
}
