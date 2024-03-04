package solved.problem1to999._500to599.findBottomLeftValue513;

class Solution {
    int bottom=0;
    int value;
    public int findBottomLeftValue(TreeNode root) {
        value=root.val;
        help(root, 0);
        return value;
    }

    private void help(TreeNode node, int depth) {
        if (node==null) {
            return;
        }
        if (depth > bottom) {
            bottom=depth;
            value = node.val;
        }
        help(node.left, depth+1);
        help(node.right, depth+1);
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
        System.out.println(solution.findBottomLeftValue(new TreeNode()));
    }
}
