/*
    Link: https://leetcode.com/problems/find-center-of-star-graph
 */
public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        if (edges[1][0] != a && edges[1][1] != a) {
            return b;
        }
        return a;
    }
}
