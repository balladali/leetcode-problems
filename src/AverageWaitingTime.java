/*
    Link: https://leetcode.com/problems/average-waiting-time
 */
public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        double result = 0;
        int start = customers[0][0];
        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] > start) {
                start = customers[i][0];
            }
            int end = start + customers[i][1];
            result += end - customers[i][0];
            start = end;
        }
        return result / customers.length;
    }
}
