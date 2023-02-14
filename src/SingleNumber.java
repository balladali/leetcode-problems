/*
    Link: https://leetcode.com/problems/single-number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int elem: nums) {
            num ^= elem;
        }
        return num;
    }
}
