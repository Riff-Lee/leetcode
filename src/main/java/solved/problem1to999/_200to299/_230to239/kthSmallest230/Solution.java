package solved.problem1to999._200to299._230to239.kthSmallest230;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        return list.get(k-1);
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            help(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            help(root.right, list);
        }
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
        TreeNode head = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        solution.kthSmallest(head, 1);
    }
}
