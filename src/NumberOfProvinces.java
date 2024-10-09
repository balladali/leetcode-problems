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

    //-----------------------------------------------------

    public int findCircleNum2(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs2(i, visited, isConnected);
            }
        }
        return count;
    }

    private void dfs2(int i, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < isConnected[0].length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs2(j, visited, isConnected);
            }
        }
    }
}
