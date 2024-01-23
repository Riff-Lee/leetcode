package solved.maxAncestorDiff1026;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int m = 0;
    public int maxAncestorDiff(TreeNode root) {

        int[] res = help(root);
        return m;
    }

    private int[] help(TreeNode root) {
        if (root == null) {
            return new int[]{5001, 0};
        }
        int[] left = help(root.left);
        int[] right = help(root.right);

        int min = Math.min(Math.min(left[0], right[0]), root.val);
        int max = Math.max(Math.max(left[1], right[1]), root.val);

        m = Math.max(m, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));


        return new int[]{min, max};
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}