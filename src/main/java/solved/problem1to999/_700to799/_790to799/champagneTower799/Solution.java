package solved.problem1to999._700to799._790to799.champagneTower799;

import java.util.*;

class Solution {
    double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured==0) {
            return 0.00000;
        }
        dp = new double[query_row+1][query_row+1];
        for (int i=0; i<=query_row; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = poured;
        double res = help(query_row, query_glass);
        return res > 1 ? 1.00000 : res;
    }

    private double help(int query_row, int query_glass) {
        if (dp[query_row][query_glass] != -1) {
            return dp[query_row][query_glass];
        }

        double left = query_glass == 0 ? 0 : help(query_row-1, query_glass-1);
        double right = query_glass == query_row ? 0 : help(query_row-1, query_glass);
        dp[query_row][query_glass] = (Math.max(left-1,0) + Math.max(right-1,0))/2;
        return dp[query_row][query_glass];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.champagneTower(25,6,1));
    }
}
