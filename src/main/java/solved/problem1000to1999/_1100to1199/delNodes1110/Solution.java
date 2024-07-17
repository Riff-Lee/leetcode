package solved.problem1000to1999._1100to1199.delNodes1110;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> deleteNum = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        help(res, root, null, true, deleteNum, true);
        return res;
    }

    private void help(List<TreeNode> res, TreeNode node, TreeNode parent, boolean left, Set<Integer> deleteNum, boolean notAdded) {
        if (node == null) {
            return;
        }

        if (!deleteNum.contains(node.val)) {
            if (notAdded) {
                res.add(node);
            }
            help(res, node.left, node, true, deleteNum, false);
            help(res, node.right, node, false, deleteNum, false);
        } else {
            if (parent != null) {
                if (left) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            help(res, node.left, null, true, deleteNum, true);
            help(res, node.right, null, true, deleteNum, true);
        }
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
        var res = solution.delNodes(new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7))),new int[]{3,5});
        System.out.println(res.toString());
    }
}
