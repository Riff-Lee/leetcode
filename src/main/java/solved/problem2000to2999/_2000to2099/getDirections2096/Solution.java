package solved.problem2000to2999._2000to2099.getDirections2096;

import java.util.*;

class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> toStart = new ArrayList<>();
        help(root, toStart, startValue);
        List<Character> toEnd = new ArrayList<>();
        help(root, toEnd, destValue);
        int index = 0;
        while (true) {
            if (index < toStart.size() && index < toEnd.size() && toStart.get(index).equals(toEnd.get(index))) {
                index++;
            } else {
                break;
            }
        }

        StringBuilder res = new StringBuilder();
        res.append("U".repeat(Math.max(0, toStart.size() - 1 - index + 1)));
        for (int i = index; i < toEnd.size(); i++) {
            res.append(toEnd.get(i));
        }
        return res.toString();
    }

    private boolean help(TreeNode root, List<Character> currentPath, int target) {
        if (root.val == target) {
            return true;
        }

        if (root.left != null) {
            currentPath.add('L');
            if (help(root.left, currentPath, target)) {
                return true;
            }
            currentPath.remove(currentPath.size()-1);
        }
        if (root.right != null) {
            currentPath.add('R');
            if (help(root.right, currentPath, target)) {
                return true;
            }
            currentPath.remove(currentPath.size()-1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.getDirections(new TreeNode(1, null, new TreeNode(10,new TreeNode(12,new TreeNode(4),new TreeNode(6)),new TreeNode(13,null,new TreeNode(15,null,new TreeNode(2))))), 6, 15);
        System.out.println(res);
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

}
