package solved.problem1to1000._201to300.isAnagram242;

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] lookup = new int[26];
        for (char c : s.toCharArray()) {
            lookup[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            lookup[c - 'a'] -= 1;
        }
        for (int i : lookup) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : sChars) {
            map.computeIfPresent(c, (k,v) -> v+1);
            map.putIfAbsent(c, 1);
        }
        char[] tChars = t.toCharArray();
        for (char c : tChars) {
            if (map.containsKey(c)) {
                int num = map.get(c) - 1;
                if (num == 0) {
                    map.remove(c);
                } else {
                    map.put(c, num);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}
