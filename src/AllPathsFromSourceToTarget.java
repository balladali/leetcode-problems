import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/all-paths-from-source-to-target
    Algorithm: BFS, DFS
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph[0].length == 0) {
            return result;
        }
        int n = graph.length;
        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0));
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            Integer num = path.get(path.size() - 1);
            if (num == n - 1) {
                result.add(new ArrayList<>(path));
            }
            for (Integer node: graph[num]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(node);
                queue.add(newPath);
            }
        }
        return result;
    }

    //--------------- DFS ------------------

    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph[0].length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(0);
        findPathDFS(graph, result, path);
        return result;
    }

    private void findPathDFS(int[][] graph, List<List<Integer>> result, List<Integer> currentPath) {
        int last = currentPath.get(currentPath.size() - 1);
        if (last == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        for (int node: graph[last]) {
            currentPath.add(node);
            findPathDFS(graph, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
