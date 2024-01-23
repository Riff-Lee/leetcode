package unsolved.strcompression1531;


import java.util.Arrays;

public class Solution {
    private int[][] dp;
    private char[] chars;
    private int n;

    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }

    private int dp(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;

        int result = dp[i][k];
        if (result != -1) return result;
        result = dp(i + 1, k - 1);
        int length = 0, same = 0, diff = 0;

        for (int j=i; j < n && diff <= k; j++) {

            if (chars[j] == chars[i]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++;
            }
            result = Math.min(result, length + dp(j + 1, k - diff));
        }
        dp[i][k] = result;
        return result;
    }

    public int getLengthOfOptimalCompression1(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 100);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int cnt = 0;
                int del = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1))
                        cnt++;
                    else
                        del++;

                    if (j - del >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1 : 0));
                    }
                }
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }

}
