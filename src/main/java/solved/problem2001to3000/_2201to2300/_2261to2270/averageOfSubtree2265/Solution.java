package solved.problem2001to3000._2201to2300._2261to2270.averageOfSubtree2265;

class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        help(root);
        return count;
    }

    //response int[] res; res[0] = sum of subtree(inclusive); res[1] = subtree node nums(inclusive)
     private int[] help(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        if (node.left == null && node.right == null) {
            count++;
            return new int[] {node.val, 1};
        }

        int[] left = help(node.left);
        int[] right = help(node.right);
        int num = left[1] + right[1] + 1;
        int sum = left[0] + right[0] + node.val;
        if (sum/num == node.val) {
            count++;
        }
        return new int[] {sum, num};
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
        System.out.println(solution.averageOfSubtree(null));
    }

}
