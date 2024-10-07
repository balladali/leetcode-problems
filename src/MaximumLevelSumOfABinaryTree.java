import java.util.LinkedList;
import java.util.Queue;

/*
    Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree
    Algorithm: BFS
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                curSum += current.val;
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }
}
