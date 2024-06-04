package solved.problem1to999._400to499._400to409.longestPalindrome409;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestPalindrome(String s) {
        int[] letterCount = new int[52];
        for (char ch : s.toCharArray()) {
            if (ch >='a' && ch<='z') {
                letterCount[ch-'a']++;
            } else {
                letterCount[ch-'A'+26]++;
            }
        }
        int reduceCount = 0;
        for (int i : letterCount) {
            if (i%2==1) {
                reduceCount++;
            }
        }
        return reduceCount==0 ? s.length() : s.length()-reduceCount+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
