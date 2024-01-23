package solved.maximalNetworkRank;

import java.util.Arrays;
import java.util.Set;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] dp = new int[n][n];
        for (int[] road : roads) {
            int r1;
            int r2;
            if (road[0] < road[1]) {
                r1 = road[0];
                r2 = road[1];
            } else {
                r1 = road[1];
                r2 = road[0];
            }
            for (int i = 0; i < r1; i++) {
                dp[i][r1] = dp[i][r1] + 1;
            }
            for (int i = r1 + 1; i < n; i++) {
                dp[r1][i] = dp[r1][i] + 1;
            }
            for (int i = 0; i < r2; i++) {
                dp[i][r2] = dp[i][r2] + 1;
            }
            for (int i = r2 + 1; i < n; i++) {
                dp[r2][i] = dp[r2][i] + 1;
            }

            dp[r1][r2] = dp[r1][r2] - 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
