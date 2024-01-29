package solved.problem1to1000._301to400.findTheDifference389;

import java.util.*;

class Solution {
    public char findTheDifference(String s, String t) {
        int[] letterNum = new int[26];
        for (char ch : s.toCharArray()) {
            letterNum[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            letterNum[ch-'a']--;
        }
        int i;
        for (i = 0; i < 26; i++) {
            if (letterNum[i] == -1) {
                break;
            }
        }
        return (char) ('a'+i);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheDifference("abcd", "abcde"));
    }
}
