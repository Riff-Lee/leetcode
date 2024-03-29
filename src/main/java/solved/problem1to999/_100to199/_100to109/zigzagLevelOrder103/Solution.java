package solved.problem1to999._100to199._100to109.zigzagLevelOrder103;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    int size = 0;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        help(res, root, 0, true);
        return res;
    }

    private void help(List<List<Integer>> res, TreeNode node, int layer, boolean zig) {
        if (node==null) {
            return;
        }
        if (layer>=size) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            res.add(list);
            size++;
        } else {
            List<Integer> list = res.get(layer);
            list.add(node.val);
        }
        if (zig) {
            help(res, node.right, layer+1, !zig);
            help(res, node.left, layer+1, !zig);
        } else {
            help(res, node.left, layer+1, !zig);
            help(res, node.right, layer+1, !zig);
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
        System.out.println(solution.zigzagLevelOrder(new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)))));
    }
}
