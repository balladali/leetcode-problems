/*
    Link: https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int aXorB = 0;
        for (int i: nums) {
            aXorB ^= i;
        }

        int rightBitSet = aXorB & -aXorB;
        int a = 0;
        for (int i: nums) {
            if ((i & rightBitSet) != 0) {
                a ^= i;
            }
        }
        return new int[] {a, a ^ aXorB};
    }
}
