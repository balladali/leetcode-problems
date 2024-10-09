import java.util.*;

/*
    Link: https://leetcode.com/problems/evaluate-division
    Algorithm: DFS
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            String d1 = e.get(0);
            String d2 = e.get(1);
            Map<String, Double> valueMap = map.getOrDefault(d1, new HashMap<>());
            valueMap.put(d2, values[i]);
            map.put(d1, valueMap);

            valueMap = map.getOrDefault(d2, new HashMap<>());
            valueMap.put(d1, 1 / values[i]);
            map.put(d2, valueMap);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String d1 = queries.get(i).get(0);
            String d2 = queries.get(i).get(1);
            if (!map.containsKey(d1) || !map.containsKey(d2)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(map, d1, d2, new HashSet<>());
            }
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> map, String d1, String d2, Set<String> visited) {
        if (d1.equals(d2)) {
            return 1.0;
        }
        visited.add(d1);
        Map<String, Double> d1Map = map.get(d1);
        if (d1Map.containsKey(d2)) {
            return d1Map.get(d2);
        }
        for (String d: d1Map.keySet()) {
            double value = d1Map.get(d);
            if (!visited.contains(d)) {
                double r = dfs(map, d, d2, visited);
                if (r != -1) {
                    return value * r;
                }
            }
        }
        return -1.0;
    }
}
