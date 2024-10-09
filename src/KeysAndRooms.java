import java.util.List;

/*
    Link: https://leetcode.com/problems/keys-and-rooms
    Algorithm: DFS
 */
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(0, rooms, visited);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private void visit(int num, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[num]) {
            return;
        }
        visited[num] = true;
        for (int n: rooms.get(num)) {
            visit(n, rooms, visited);
        }
    }
}
