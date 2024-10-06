import java.util.HashMap;
import java.util.Map;

/*
    Link: https://leetcode.com/problems/path-sum-iii
    Algorithm: Binary Tree, DFS
 */
public class PathSum3 {
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        helper(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return result;
    }

    private void helper(TreeNode node, long currentSum, int targetSum) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
        if (currentSum == targetSum) {
            result++;
        }
        helper(node.left, currentSum, targetSum);
        helper(node.right, currentSum, targetSum);
    }

    //------------------ Prefix Sum ---------------------

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);
        return helper(root, 0, targetSum, prefixSumMap);
    }

    private int helper(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        int numPaths = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        numPaths += helper(node.left, currentSum, targetSum, prefixSumMap);
        numPaths += helper(node.right, currentSum, targetSum, prefixSumMap);

        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) - 1);
        return numPaths;
    }
}
