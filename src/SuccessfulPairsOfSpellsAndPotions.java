import java.util.Arrays;

/*
    Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions
    Algorithm: Binary Search
 */
public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            result[i] = binarySearch(potions, spells[i], success);
        }
        return result;
    }

    private int binarySearch(int[] arr, int m, long success) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long prod = (long) m * arr[mid];
            if (prod < success) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return arr.length - l;
    }
}
