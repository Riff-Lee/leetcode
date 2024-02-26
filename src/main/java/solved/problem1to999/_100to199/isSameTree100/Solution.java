package solved.problem1to999._100to199.isSameTree100;


import java.util.*;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p==null && q==null;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
        System.out.println(solution.isSameTree(new TreeNode(0,new TreeNode(-5),null),new TreeNode(0,new TreeNode(-8),null)));
    }
}
