import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/balance-a-binary-search-tree
    Algorithm: DFS
 */
public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return balance(list, 0, list.size() - 1);
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    private TreeNode balance(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = balance(list, start, mid - 1);
        TreeNode right = balance(list, mid + 1, end);
        return new TreeNode(list.get(mid), left, right);
    }
}
