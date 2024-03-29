package solved.problem1to999._100to199._120to129.maxPathSum124;


public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        help(root);
        return max;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, help(node.left));
        int right = Math.max(0, help(node.right));
        max = Math.max(max, left+right+ node.val);
        return Math.max(left,right) + node.val;
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
        solution.maxPathSum(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6))));
    }
}
