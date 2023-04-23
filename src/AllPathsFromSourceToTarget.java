import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/all-paths-from-source-to-target
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
}
