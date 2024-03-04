package solved.problem1000to1999._1600to1699.isEvenOddTree1609;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    int[] oddLastNumber = new int[100000];
    int[] evenLastNumber = new int[100000];

    public boolean isEvenOddTree(TreeNode root) {
        Arrays.fill(oddLastNumber, 1000001);
        return help(root, 0);
    }

    private boolean help(TreeNode node, int level) {
        if (node==null) {
            return true;
        }
        if (level%2==0) {
            if (node.val%2==0 || node.val <= evenLastNumber[level]) {
                return false;
            }
            evenLastNumber[level] = node.val;
        } else {
            if (node.val%2!=0 || node.val >= oddLastNumber[level]) {
                return false;
            }
            oddLastNumber[level] = node.val;
        }
        return help(node.left,level+1) && help(node.right, level+1);
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
        System.out.println(solution.isEvenOddTree(new TreeNode(2,new TreeNode(3, new TreeNode(3), new TreeNode(1)),new TreeNode(1,null,new TreeNode(1)))));
    }
}
