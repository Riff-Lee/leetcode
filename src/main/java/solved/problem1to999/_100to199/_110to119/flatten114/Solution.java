package solved.problem1to999._100to199._110to119.flatten114;


public class Solution {
    public void flatten(TreeNode root) {
        help(root);
    }

    private TreeNode help(TreeNode node) {
        if (node==null) {
            return null;
        }
        TreeNode left = help(node.left);
        TreeNode right = help(node.right);
        if (left==null) {
            node.left = null;
            node.right = right;
        } else if (right == null) {
            node.left = null;
            node.right = left;
        } else {
            TreeNode rec = left;
            while (left.right!=null) {
                left = left.right;
            }
            left.right = right;
            node.right = rec;
            node.left = null;
        }
        return node;
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
        solution.flatten(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6))));
    }
}
