package solved.problem1001to2000._1701to1800.minOperations1758;

import java.util.*;

class Solution {
    public int minOperations(String s) {
        int chgNum = 0;
        char startChar = '0';
        for (char ch : s.toCharArray()) {
            if (ch == startChar) {
                chgNum++;
            }
            startChar = startChar == '0' ? '1' : '0';
        }
        return Math.min(chgNum, s.length()-chgNum);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("0100"));
    }
}
