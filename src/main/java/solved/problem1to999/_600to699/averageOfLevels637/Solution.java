package solved.problem1to999._600to699.averageOfLevels637;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    long[][] dp = new long[10000][2];
    int deepest = 0;
    public List<Double> averageOfLevels(TreeNode root) {
        help(root,0);
        List<Double> res = new ArrayList<>();
        for (int i=0;i<=deepest;i++) {
            Double d = (double)dp[i][0]/(double)dp[i][1];
            String s = String.format("%.5f", d);
            res.add(Double.valueOf(s));
        }
        return res;
    }

    private void help(TreeNode node, int layer) {
        if (node == null) {
            return;
        }
        dp[layer][0] += node.val;
        dp[layer][1]++;
        deepest = Math.max(deepest, layer);
        help(node.left, layer+1);
        help(node.right, layer+1);

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
        solution.averageOfLevels(new TreeNode(2147483647));
    }
}
