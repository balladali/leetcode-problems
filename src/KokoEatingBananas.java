/*
    Link: https://leetcode.com/problems/koko-eating-bananas/
    Algorithm: Binary Search
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MAX_VALUE; // можно также использовать сумму всех piles
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canEat(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canEat(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile: piles) {
            hours += pile / k;
            if (pile % k > 0) {
                hours++;
            }
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}
