package solved.problem1to999._200to299._200to209.isIsomorphic205;

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        char[] sources = s.toCharArray();
        char[] targets = t.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            if (map.containsKey(sources[i])) {
                if (targets[i]!=map.get(sources[i])) {
                    return false;
                }
            } else {
                map.put(sources[i],targets[i]);
            }
        }
        Map<Character, Character> map1 = new HashMap<>();
        for (int i=0;i<n;i++) {
            if (map1.containsKey(targets[i])) {
                if (sources[i]!=map1.get(targets[i])) {
                    return false;
                }
            } else {
                map1.put(targets[i],sources[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg","add"));
    }
}
