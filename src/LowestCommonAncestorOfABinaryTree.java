import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
    Algorithm: DFS
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    //----------------------------------------------------------------

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        findWay(root, p, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        findWay(root, q, qPath);
        int i = 0;
        int j = 0;
        while (i < pPath.size() && j < qPath.size() && pPath.get(i).equals(qPath.get(j))) {
            i++;
            j++;
        }
        return pPath.get(i - 1);
    }

    private boolean findWay(TreeNode node, TreeNode nodeToFind, List<TreeNode> path) {
        if (node == null) {
            return false;
        }
        path.add(node);
        if (node.equals(nodeToFind)) {
            return true;
        }
        if (findWay(node.left, nodeToFind, path) || findWay(node.right, nodeToFind, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
