/*
    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    Algorithm: DP
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int result = 0;
        int n = prices.length - 1;
        int i = 0;
        while (i < n) {
            while (i < n && prices[i + 1] <= prices[i]) {
                i++;
            }
            int buy = prices[i];
            while (i < n && prices[i + 1] > prices[i]) {
                i++;
            }
            int sell = prices[i];
            result += sell - buy;
        }
        return result;
    }
}
