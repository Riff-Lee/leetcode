package solved.problem1001to2000._1101to1200._1141to1150.longestCommonSubsequence1143;

import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();
        return help(dp, char1, char2, text1.length()-1, text2.length()-1);
    }

    private int help(int[][] dp, char[] char1, char[] char2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (char1[i] == char2[j]) {
            dp[i][j] = help(dp, char1, char2, i-1, j-1) + 1;
            return dp[i][j];
        }
        dp[i][j] = Math.max(help(dp, char1, char2, i, j-1), help(dp, char1, char2, i-1, j));
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }
}
