/*
    Link: https://leetcode.com/problems/number-of-provinces
    Algorithm: DFS
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                count++;
                dfs(isConnected, i);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i) {
        isConnected[i][i] = 0;
        for (int j = 0; j < isConnected[0].length; j++) {
            if (isConnected[j][j] == 1 && isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                isConnected[j][i] = 0;
                dfs(isConnected, j);
            }
        }
    }
}
