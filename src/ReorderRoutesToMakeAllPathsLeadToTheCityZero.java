import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
    Algorithm: DFS
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] conn: connections) {
            int a = conn[0];
            int b = conn[1];
            graph.get(a).add(new int[]{b, 1});
            graph.get(b).add(new int[]{a, -1});
        }

        return dfs(graph, new boolean[n], 0);
    }

    private int dfs(List<List<int[]>> graph, boolean[] visited, int i) {
        int changes = 0;
        visited[i] = true;
        for (int[] conn: graph.get(i)) {
            if (!visited[conn[0]]) {
                if (conn[1] > 0) {
                    changes++;
                }
                changes += dfs(graph, visited, conn[0]);
            }
        }
        return changes;
    }
}
