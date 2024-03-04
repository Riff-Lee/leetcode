package solved.problem1to999._1to99._1to9.lengthOfLongestSubstring3;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                num++;
                max = Math.max(num, max);
            } else {
                i = map.get(chars[i]);
                map = new HashMap<>();
                num = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}
