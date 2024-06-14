package solved.problem1to999._600to699.kInversePairs629;

import java.util.Arrays;

class Solution {

    public int kInversePairs1(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        int mod = 1000000007;

        for(int i = 1; i <= n; i++) {
            int val = 0;
            for(int j = 0; j <= k; j++) {
                val += dp[i - 1][j];
                if(j >= i) val -= dp[i - 1][j - i];
                if(val < 0) val += mod;
                val = (val % mod);
                dp[i][j] = val;
            }
        }
        return (int)(dp[n][k]);
    }

    //time limit
    int[][] dp;
    int mod =1000000007;
    public int kInversePairs(int n, int k) {
        dp = new int[n+1][k+1];
        for (int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }

        return help(n, k);
    }

    private int help(int n, int k) {
        if (k==0) {
            dp[n][k] = 1;
            return 1;
        }
        if (n==1 || n==0) {
            dp[n][k] = 0;
            return 0;
        }
        if (dp[n][k]!=-1){
            return dp[n][k];
        }
        int max = n*(n-1)/2;
        if (k>max) {
            dp[n][k] = 0;
            return 0;
        }
        int i = Math.max(k-n+1, 0);
        int res = 0;
        for (;i<=k;i++) {
            res = (res + help(n-1, i))%mod;
        }
        dp[n][k] = res%mod;
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kInversePairs(1000,1000));
    }
}
