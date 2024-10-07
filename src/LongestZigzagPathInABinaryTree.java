/*
    Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
    Algorithm: DFS
 */
public class LongestZigzagPathInABinaryTree {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    private void dfs(TreeNode node, boolean isLeft, int curLength) {
        if (node == null) {
            return;
        }
        max = Math.max(max, curLength);
        if (isLeft) {
            dfs(node.right, false, curLength + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.right, false, 1);
            dfs(node.left, true, curLength + 1);
        }
    }
}
