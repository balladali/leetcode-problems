import java.util.LinkedList;

/*
    Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node
    Algorithm: Depth First Search, Breadth First Search
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        point(root, null);
        return root;
    }

    private void point(Node node1, Node node2) {
        if (node1 == null) {
            return;
        }
        node1.next = node2;
        point(node1.left, node1.right);
        if (node2 != null) {
            point(node1.right, node2.left);
            point(node2.left, node2.right);
        }
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
