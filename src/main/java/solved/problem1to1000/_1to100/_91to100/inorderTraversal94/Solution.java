package solved.problem1to1000._1to100._91to100.inorderTraversal94;

import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorder(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            inorder(node.right, res);
        }
    }

    static class TreeNode {
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
        System.out.println(solution.inorderTraversal(null));
    }

}
