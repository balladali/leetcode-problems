/*
    LinK: https://leetcode.com/problems/count-good-nodes-in-binary-tree
    Algorithm: Binary Tree
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return 1 + helper(root.left, root.val) + helper(root.right, root.val);
    }

    private int helper(TreeNode root, int currentMax) {
        if (root == null) {
            return 0;
        }
        int count = root.val < currentMax ? 0 : 1;
        currentMax = Math.max(currentMax, root.val);
        return count + helper(root.right, currentMax) + helper(root.left, currentMax);
    }
}
