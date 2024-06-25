/*
    https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
    Algorithm: DFS
 */
public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode node, int curSum) {
        if (node == null) {
            return 0;
        }
        if (node.right == null) {
            node.val += curSum;
        } else {
            node.val += helper(node.right, curSum);
        }
        curSum = node.val;
        if (node.left == null) {
            return curSum;
        }
        curSum = helper(node.left, curSum);
        return curSum;
    }
}
