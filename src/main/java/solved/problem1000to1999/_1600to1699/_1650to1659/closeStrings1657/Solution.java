package solved.problem1000to1999._1600to1699._1650to1659.closeStrings1657;

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()) {
            return false;
        }
        int[] letterCount1 = new int[26];
        Set<Character> characters1 = new HashSet<>();
        for (char ch: word1.toCharArray()) {
            letterCount1[ch-'a']++;
            characters1.add(ch);
        }
        int[] letterCount2 = new int[26];
        Set<Character> characters2 = new HashSet<>();
        for (char ch: word2.toCharArray()) {
            letterCount2[ch-'a']++;
            characters2.add(ch);
        }
        if (!characters1.equals(characters2)) {
            return false;
        }
        Map<Integer, Integer> countLetter1 = new HashMap<>();
        for (int count : letterCount1) {
            if (count>0) {
                countLetter1.put(count, countLetter1.getOrDefault(count, 0)+1);
            }
        }
        for (int count : letterCount2) {
            if (count>0) {
                if (!countLetter1.containsKey(count)||countLetter1.get(count)==0) {
                    return false;
                }
                countLetter1.put(count, countLetter1.get(count)-1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countLetter1.entrySet()) {
            if (entry.getValue()>0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("abc","bca"));
    }
}
