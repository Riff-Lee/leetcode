package solved.problem1to1000._501to600.findPaths576;

import java.util.*;

class Solution {
    int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return help(m,n,maxMove,startRow,startColumn);
    }

    private int help(int m, int n, int maxMove, int startRow, int startColumn) {
        if (dp[startRow][startColumn][maxMove] != -1) {
            return dp[startRow][startColumn][maxMove];
        }
        if (maxMove == 0) {
            dp[startRow][startColumn][maxMove] = 0;
            return dp[startRow][startColumn][maxMove];
        }
        if (maxMove == 1) {
            int count = 0;
            if (startColumn == 0) {
                count++;
            }
            if (startColumn == n-1) {
                count++;
            }
            if (startRow == 0) {
                count++;
            }
            if (startRow == m-1) {
                count++;
            }
            dp[startRow][startColumn][maxMove] = count;
            return dp[startRow][startColumn][maxMove];
        }
        int left = startColumn == 0 ? 1 : help(m,n,maxMove-1,startRow,startColumn-1);
        int right = startColumn == n-1 ? 1 : help(m,n,maxMove-1,startRow,startColumn+1);
        int up = startRow == 0 ? 1 : help(m,n,maxMove-1,startRow-1,startColumn);
        int down = startRow == m-1 ? 1 : help(m,n,maxMove-1,startRow+1,startColumn);
        dp[startRow][startColumn][maxMove] = ((left+right)%1000000007+(up+down)%1000000007)%1000000007;
        return dp[startRow][startColumn][maxMove];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPaths(8,50,23,5,26));
    }
}
