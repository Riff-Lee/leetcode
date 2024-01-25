package solved.problem1to1000._1to100._61to70.climbStairs70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
//        int[] factorial = new int[n+1];
//        factorial[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            factorial[i] = factorial[i-1] * i;
//        }
//        int res = 1;
//        for (int i=1; i<=n/2; i++) {
//            res += factorial[n-i] / (factorial[n-2*i] * factorial[i]);
//        }
//        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
