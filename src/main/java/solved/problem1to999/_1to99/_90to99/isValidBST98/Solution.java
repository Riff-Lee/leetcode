package solved.problem1to999._1to99._90to99.isValidBST98;

import java.util.ArrayList;
import java.util.List;

class Solution {
    Integer last;
    public boolean isValidBST(TreeNode root) {
        if (root.left != null && (!isValidBST(root.left))) {
            return false;
        }
        if (last != null && last >= root.val) {
            return false;
        }
        last = root.val;
        if (root.right != null && (!isValidBST(root.right))) {
            return false;
        }
        return true;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = new TreeNode(1, new TreeNode(1), null);
        solution.isValidBST(head);
    }
}
