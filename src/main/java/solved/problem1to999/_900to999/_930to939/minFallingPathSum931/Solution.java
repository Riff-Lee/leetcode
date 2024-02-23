package solved.problem1to1000._901to1000._931to40.minFallingPathSum931;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int[][] dp = new int[n][n];
        dp[n-1] = matrix[n-1];
        for (int i = n-2; i>=0; i--) {
            for (int j=0; j<n;j++) {
                if (j==0) {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + matrix[i][j];
                } else if (j==n-1) {
                    dp[i][j] = Math.min(dp[i+1][j-1],dp[i+1][j]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i+1][j-1],dp[i+1][j]), dp[i+1][j+1]) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            min = Math.min(dp[0][k], min);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][] {{2,1,3}, {6,5,4}, {7,8,9}}));
    }
}
