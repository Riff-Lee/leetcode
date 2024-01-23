package solved.wordbreak139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= maxLength && i-j>=0; j++) {
                if (wordDict.contains(s.substring(i - j, i)) && dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
