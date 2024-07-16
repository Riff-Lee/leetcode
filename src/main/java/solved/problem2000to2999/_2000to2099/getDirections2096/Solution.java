package solved.problem2000to2999._2000to2099.getDirections2096;

import java.util.*;

class Solution {
    boolean findStart;
    boolean findDest;
    int start;
    int dest;
    String[] path = new String[2];
    int[][] numbers = new int[2][100001];

    public String getDirections(TreeNode root, int startValue, int destValue) {
        start = startValue;
        dest = destValue;
        help(root, "", null, 0);
        char[] startChars = path[0].toCharArray();
        char[] destChars = path[1].toCharArray();
        int index = 0;
        while (true) {
            if (index < startChars.length && index < destChars.length && startChars[index] == destChars[index]) {
                index++;
            } else {
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = startChars.length - 1; i >= index; i--) {
            if (startChars[i] == 'L' || startChars[i] == 'R') {
                res.append('U');
            }
        }
        for (int i = index; i < destChars.length; i++) {
            if (destChars[i] == 'L' || destChars[i] == 'R') {
                res.append(destChars[i]);
            }
        }
        return res.toString();
    }

    private void help(TreeNode root, String currentPath, int[] number, int seq) {
        if (number == null) {
            number = new int[10001];
        }
        number[seq] = root.val;
        if (root.val == start) {
            findStart = true;
            path[0] = currentPath;
            numbers[0] = Arrays.copyOf(number, 10001);
        }
        if (root.val == dest) {
            findDest = true;
            path[1] = currentPath;
            numbers[1] = Arrays.copyOf(number, 10001);
        }
        if (findDest && findStart) {
            return;
        }
        if (root.left != null) {
            help(root.left, currentPath + "L", Arrays.copyOf(number, 10001), seq+1);
        }
        if (root.right != null) {
            help(root.right, currentPath + "R", Arrays.copyOf(number, 10001), seq+1);
        }
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
