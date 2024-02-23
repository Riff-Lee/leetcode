package solved.problem1to1000._801to900.leafSimilar872;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null) {
            return root1==null&&root2==null;
        }
        List<Integer> leftLeaf = new ArrayList<>();
        List<Integer> rightLeaf = new ArrayList<>();
        findLeafSeq(root1, leftLeaf);
        findLeafSeq(root2, rightLeaf);
        return leftLeaf.equals(rightLeaf);
    }

    private void findLeafSeq(TreeNode node, List<Integer> res) {
        if (node.left==null&&node.right==null) {
            res.add(node.val);
            return;
        }
        if (node.left!=null) {
            findLeafSeq(node.left,res);
        }
        if (node.right!=null) {
            findLeafSeq(node.right,res);
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
        System.out.println(solution.leafSimilar(null,null));
    }
}
