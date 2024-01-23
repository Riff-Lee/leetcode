package solved.numberdicewithtargetsum1155;


public class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if (target > n * k || target < n) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n][target];
        for (int j = 0; j < k && j < target; j++){
            dp[0][j] = 1;
        }
        int mod = 1000000007;

        for (int i = 1; i < n; i++) {
            for (int j = i; j < target && j <= (i+1)*k; j++) {
                for (int m = j-1; m >=j-k && m >=0; m--) {
                    dp[i][j] = (dp[i][j] + dp[i-1][m]) % mod;
                }
            }
        }

        return dp[n-1][target-1];
    }

}
