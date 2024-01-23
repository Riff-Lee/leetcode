package solved.sumNumbers129;


import java.util.*;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode node, int path) {
        if (node == null) {
            return path;
        }
        if (node.right == null && node.left == null) {
            return path*10+node.val;
        }
        if (node.right == null) {
            return help(node.left, path*10+node.val);
        }
        if (node.left == null) {
            return help(node.right, path*10+node.val);
        }

        return help(node.right, path*10+node.val) + help(node.left, path*10+node.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
        System.out.println(solution.sumNumbers(new TreeNode(1, new TreeNode(0), null)));
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
