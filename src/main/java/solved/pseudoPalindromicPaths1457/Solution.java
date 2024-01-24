package solved.pseudoPalindromicPaths1457;


import java.util.*;

public class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        help(root, new HashSet<>());
        return count;
    }

    private void help(TreeNode node, Set<Integer> oddNums) {
        if (node==null) {
            return;
        }
        if (oddNums.contains(node.val)) {
            oddNums.remove(node.val);
        } else {
            oddNums.add(node.val);
        }
        if (node.left == null && node.right == null) {
            if (oddNums.size()<=1) {
                count++;
            }
            if (oddNums.contains(node.val)) {
                oddNums.remove(node.val);
            } else {
                oddNums.add(node.val);
            }
            return;
        }
        help(node.left, oddNums);
        help(node.right, oddNums);
        if (oddNums.contains(node.val)) {
            oddNums.remove(node.val);
        } else {
            oddNums.add(node.val);
        }
    }

    /**
     * int ans =0;
     *     public int pseudoPalindromicPaths (TreeNode root) {
     *         func(root, 0);
     *         return ans;
     *     }
     *     void func(TreeNode node, int seen){
     *         if(node == null) return;
     *         // System.out.println("b4 " + Integer.toBinaryString(seen));
     *         seen^=(1<<node.val);
     *         // System.out.println("after " + Integer.toBinaryString(seen));
     *         if(node.left == null && node.right == null){
     *             if((seen & (seen-1)) == 0){
     *                 ans++;
     *             }
     *             return;
     *         }
     *         func(node.left, seen);
     *         func(node.right, seen);
     *
     *     }
     */

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
        System.out.println(solution.pseudoPalindromicPaths(new TreeNode(2,new TreeNode(3, new TreeNode(3), new TreeNode(1)),new TreeNode(1,null,new TreeNode(1)))));
    }
}
