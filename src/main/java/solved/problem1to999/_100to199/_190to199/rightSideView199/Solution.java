package solved.problem1to999._100to199._190to199.rightSideView199;


import java.util.*;

public class Solution {
    int deep = -1;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res, 0);
        return res;
    }

    private void help(TreeNode node, List<Integer> res, int layer) {
        if (node==null) {
            return;
        }
        if (deep<layer) {
            res.add(node.val);
            deep=layer;
        }
        help(node.right, res, layer+1);
        help(node.left, res, layer+1);
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
        solution.rightSideView(new TreeNode(3,new TreeNode(5,new TreeNode(6),
                new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1)));
    }
}
