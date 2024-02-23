package solved.problem1001to2000._1601to1700._1621to1630.maxLengthBetweenEqualCharacters1624;

import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] dp = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], -1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (dp[chars[i]-'a'][0] == -1) {
                dp[chars[i]-'a'][0] = i;
            } else {
                dp[chars[i]-'a'][1] = i;
            }
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (dp[i][0] != -1 && dp[i][1] != -1) {
                max = Math.max(max, dp[i][1] - dp[i][0] - 1);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("aa"));
    }
}
