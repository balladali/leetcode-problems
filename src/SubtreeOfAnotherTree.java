/*
    Link: https://leetcode.com/problems/subtree-of-another-tree
    Algorithm: DFS
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return root == subRoot;
        }
        return checkSubtree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean checkSubtree(TreeNode node, TreeNode subRoot) {
        if (subRoot == null || node == null) {
            return subRoot == node;
        }
        return node.val == subRoot.val && checkSubtree(node.left, subRoot.left) && checkSubtree(node.right, subRoot.right);
    }
}
