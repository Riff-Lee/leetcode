package solved.problem1001to2000._1401to1500.maxScore1422;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxScore(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] preZeros = new int[n];
        preZeros[0] = chars[0] == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            preZeros[i] = chars[i] == '0' ? preZeros[i-1] + 1 : preZeros[i-1];
        }
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max, preZeros[i] + n-i-1 - (preZeros[n-1]-preZeros[i]));
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore("01"));
    }
}
