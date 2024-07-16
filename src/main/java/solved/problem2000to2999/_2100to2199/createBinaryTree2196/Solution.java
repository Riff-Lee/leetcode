package solved.problem2000to2999._2100to2199.createBinaryTree2196;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] des : descriptions) {
            TreeNode parent;
            if (map.containsKey(des[0])) {
                parent = map.get(des[0]);
            } else {
                parent = new TreeNode(des[0]);
                map.put(des[0], parent);
            }
            TreeNode current;
            if (map.containsKey(des[1])) {
                current = map.get(des[1]);
            } else {
                current = new TreeNode(des[1]);
                map.put(des[1], current);
            }
            children.add(des[1]);
            if (des[2]==1) {
                parent.left = current;
            } else {
                parent.right = current;
            }
        }
        for (int key: map.keySet()) {
            if (!children.contains(key)) {
                return map.get(key);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createBinaryTree(new int[][]{{85,82,1},{74,85,1},{39,70,0},{82,38,1},{74,39,0},{39,13,1}});
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

}
