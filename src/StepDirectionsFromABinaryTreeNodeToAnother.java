/*
    Link: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
    Algorithm: DFS
 */
public class StepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sPath = new StringBuilder();
        StringBuilder dPath = new StringBuilder();
        TreeNode common = getCommonAncestor(root, startValue, destValue);
        findWay(common, startValue, sPath);
        findWay(common, destValue, dPath);
        int i = 0;
        while (i < sPath.length() && i < dPath.length() && sPath.charAt(i) == dPath.charAt(i)) {
            sPath.deleteCharAt(i);
            dPath.deleteCharAt(i);
            i++;
        }
        for (int j = i; j < sPath.length(); j++) {
            sPath.setCharAt(j, 'U');
        }
        return sPath.toString() + dPath.toString();
    }

    private boolean findWay(TreeNode node, int value, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == value) {
            return true;
        }
        path.append("L");
        if (findWay(node.left, value, path)) {
            return true;
        }
        path.setCharAt(path.length() - 1, 'R');
        if (findWay(node.right, value, path)) {
            return true;
        } else {
            path.setLength(path.length() - 1);
        }
        return false;
    }

    private TreeNode getCommonAncestor(TreeNode node, int s, int d) {
        if (node == null || node.val == s || node.val == d) {
            return node;
        }
        TreeNode left = getCommonAncestor(node.left, s, d);
        TreeNode right = getCommonAncestor(node.right, s, d);
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}
