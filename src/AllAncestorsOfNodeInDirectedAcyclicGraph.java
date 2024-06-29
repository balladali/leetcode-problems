import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
    Algorithm: DFS
 */
public class AllAncestorsOfNodeInDirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
            children.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            children.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, result, children);
        }
        return result;
    }

    private void dfs(int x, int cur, List<List<Integer>> result, List<List<Integer>> children) {
        for (int child: children.get(cur)) {
            if (result.get(child).isEmpty() || result.get(child).get(result.get(child).size() - 1) != x) {
                result.get(child).add(x);
                dfs(x, child, result, children);
            }
        }
    }
}
