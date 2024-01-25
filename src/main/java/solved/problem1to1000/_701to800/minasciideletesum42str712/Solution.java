package solved.problem1to1000._701to800.minasciideletesum42str712;

import java.util.Arrays;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int sum1 = Arrays.stream(s1.chars().toArray()).sum();
        int sum2 = Arrays.stream(s2.chars().toArray()).sum();

        return sum1+sum2-2*dp[s1.length()][s2.length()];
    }

}
