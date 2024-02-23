package solved.problem1to1000._301to400._381to390.firstUniqChar387;

import java.util.*;

class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        int[] index = new int[26];
        char[] seq = new char[26];
        int i=0;
        char[] chars = s.toCharArray();
        for (int j = 0; j < s.length(); j++) {
            char ch = chars[j];
            if (alphabet[ch-'a']==0) {
                index[i] = j;
                seq[i++] = ch;
            }
            alphabet[ch-'a']++;
        }
        for (int j=0; j<i;j++) {
            char ch = seq[j];
            if (alphabet[ch-'a']==1) {
                return index[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("aabb"));
    }
}
