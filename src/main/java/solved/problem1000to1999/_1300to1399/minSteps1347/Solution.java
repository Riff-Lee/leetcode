package solved.problem1000to1999._1300to1399.minSteps1347;


import java.util.Arrays;

public class Solution {
    public int minSteps(String s, String t) {
        int[] letters = new int[26];
        for (char ch:s.toCharArray()) {
            letters[ch-'a']++;
        }
        for (char ch:t.toCharArray()) {
            letters[ch-'a']--;
        }
        int res = 0;
        for (int num : letters) {
            res+=Math.abs(num);
        }
        return res/2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps("leetcode", "practice"));
    }
}
