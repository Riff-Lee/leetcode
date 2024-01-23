package solved.strangeprinter664;

import java.util.Arrays;

public class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >=0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j]-1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public int strangePrinter1(String s) {

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return cal(dp, s, 0, s.length()-1);
    }

    public int cal(int[][] dp, String s, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = 1;
            return dp[i][j];
        }


        dp[i][j] = 1 + cal(dp, s, i+1, j);
        for (int k = i + 1; k < j; k++) {
            dp[i][j] = Math.min(cal(dp, s, i, k)+cal(dp, s, k+1, j), dp[i][j]);
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dp[i][j] - 1;
        }
        return dp[i][j];
    }

}
