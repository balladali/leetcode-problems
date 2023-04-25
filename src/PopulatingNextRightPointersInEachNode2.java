import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
    Algorithm: DFS, BFS
 */
public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        point(List.of(root));
        return root;
    }

    private void point(List<Node> nodes) {
        List<Node> nextNodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node current = nodes.get(i);
            Node next = i + 1 == nodes.size() ? null : nodes.get(i + 1);
            current.next = next;
            if (current.left != null) {
                nextNodes.add(current.left);
            }
            if (current.right != null) {
                nextNodes.add(current.right);
            }
        }
        if (!nextNodes.isEmpty()) {
            point(nextNodes);
        }
    }

    //--------------- BFS -----------------

    public Node connectBFS(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i < size - 1) {
                    current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }
}
