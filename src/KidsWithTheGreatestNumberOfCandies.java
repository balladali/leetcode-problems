import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 */
public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c: candies) {
            max = Math.max(c, max);
        }
        List<Boolean> result = new ArrayList<>();
        for (int c: candies) {
            result.add(c + extraCandies >= max);
        }
        return result;
    }
}
