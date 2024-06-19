/*
    Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
    Algorithm: Binary Search
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value: bloomDay) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (getPossibleBouquets(bloomDay, mid, k) < m) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int getPossibleBouquets(int[] bloomDay, int day, int k) {
        int bouquets = 0;
        int count = 0;
        for (int value: bloomDay) {
            if (value <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                bouquets++;
                count = 0;
            }
        }
        return bouquets;
    }
}
