import java.util.ArrayList;
import java.util.List;

/*
    Link: https://leetcode.com/problems/leaf-similar-trees
    Algorithm: Binary Tree
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        helper(root1, leaves1);
        helper(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void helper(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        helper(root.left, leaves);
        helper(root.right, leaves);
    }
}
