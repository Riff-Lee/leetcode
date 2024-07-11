package solved.problem1to999._500to599.getMinimumDifference530;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        help(root);
        return min;
    }

    private int[] help(TreeNode node) {
        int leftMax;
        int rightMin;
        if (node.right!=null) {
            int[] right = help(node.right);
            min = Math.min(min, right[1]-node.val);
            leftMax = right[0];
        } else {
            leftMax = node.val;
        }
        if (node.left!=null) {
            int[] left = help(node.left);
            min = Math.min(min, node.val-left[0]);
            rightMin = left[1];
        } else {
            rightMin = node.val;
        }
        return new int[]{leftMax, rightMin};
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(new TreeNode(334, new TreeNode(277, null, new TreeNode(285)), new TreeNode(507,null,new TreeNode(678)))));
    }
}
