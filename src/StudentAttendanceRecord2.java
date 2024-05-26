/*
    Link: https://leetcode.com/problems/student-attendance-record-ii/
    Algorithm: DP
 */
public class StudentAttendanceRecord2 {
    private static final int MOD = 1000000007;
    private static int[][][] memo;

    public static int checkRecord(int n) {
        memo = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return combine(n, memo, 0, 0);
    }

    private static int combine(int n, int[][][] memo, int totalAbsent, int consecutiveLate) {
        if (totalAbsent >= 2 || consecutiveLate >= 3) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n][totalAbsent][consecutiveLate] != -1) {
            return memo[n][totalAbsent][consecutiveLate];
        }
        int count = combine(n - 1, memo, totalAbsent, 0) % MOD;
        count = (count + combine(n - 1, memo, totalAbsent + 1, 0)) % MOD;
        count = (count + combine(n - 1, memo, totalAbsent, consecutiveLate + 1)) % MOD;
        memo[n][totalAbsent][consecutiveLate] = count;
        return memo[n][totalAbsent][consecutiveLate];
    }

    public int checkRecord2(int n) {
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int len = 0; len < n; len++) {
            for (int totalAbsent = 0; totalAbsent < 2; totalAbsent++) {
                for (int consecutiveLate = 0; consecutiveLate < 3; consecutiveLate++) {
                    dp[len + 1][totalAbsent][0] = (dp[len + 1][totalAbsent][0] + dp[len][totalAbsent][consecutiveLate]) % MOD;
                    if (totalAbsent < 1) {
                        dp[len + 1][totalAbsent + 1][0] = (dp[len + 1][totalAbsent + 1][0] + dp[len][totalAbsent][consecutiveLate]) % MOD;
                    }
                    if (consecutiveLate < 2) {
                        dp[len + 1][totalAbsent][consecutiveLate + 1] = (dp[len + 1][totalAbsent][consecutiveLate + 1] + dp[len][totalAbsent][consecutiveLate]) % MOD;
                    }
                }
            }
        }

        int count = 0;
        for (int totalAbsent = 0; totalAbsent < 2; totalAbsent++) {
            for (int consecutiveLate = 0; consecutiveLate < 3; consecutiveLate++) {
                count = (count + dp[n][totalAbsent][consecutiveLate]) % MOD;
            }
        }
        return count;
    }
}
