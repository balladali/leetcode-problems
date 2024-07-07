/*
    Link: https://leetcode.com/problems/water-bottles
 */
public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles / numExchange > 0) {
            int drink = numBottles / numExchange;
            numBottles = drink + numBottles % numExchange;
            result += drink;
        }
        return result;
    }
}
