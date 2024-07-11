package solved.problem1to999._100to199._100to109.zigzagLevelOrder103;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> nextRow = new ArrayList<>();
        nextRow.add(root);
        help(res, nextRow, 0);
        return res;
    }

    private void help(List<List<Integer>> res, List<TreeNode> row, int layer) {
        if (row==null || row.isEmpty()) {
            return;
        }
        List<Integer> rowRes = new ArrayList<>();
        List<TreeNode> nextRow = new ArrayList<>();
        for (int i = row.size() - 1; i >= 0; i--) {
            TreeNode treeNode = row.get(i);
            rowRes.add(treeNode.val);
            if (layer % 2 == 0) {
                if (treeNode.left != null) {
                    nextRow.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextRow.add(treeNode.right);
                }
            } else {
                if (treeNode.right != null) {
                    nextRow.add(treeNode.right);
                }
                if (treeNode.left != null) {
                    nextRow.add(treeNode.left);
                }
            }

        }
        res.add(rowRes);
        help(res, nextRow, layer+1);
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
        System.out.println(solution.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
