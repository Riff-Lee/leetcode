package solved.rangesumofBTS938;

import java.util.Arrays;

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
    public int rangeSumBST(TreeNode root, int low, int high) {

        return solve(root, low, high);
    }

    private int solve(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val == low) {
            return root.val + solve(root.right, low, high);
        }
        if (root.val < low) {
            return solve(root.right, low, high);
        }
        if (root.val == high) {
            return root.val + solve(root.left, low, high);
        }
        if (root.val > high) {
            return solve(root.left, low, high);
        }
        return root.val + solve(root.left, low, high) + solve(root.right, low, high);
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