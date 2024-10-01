/*
    Link: https://leetcode.com/problems/can-place-flowers
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyPrev = i == 0 || flowerbed[i - 1] == 0;
                boolean emptyNext = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

                if (emptyPrev && emptyNext) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }
        return n <= 0;
    }
}
