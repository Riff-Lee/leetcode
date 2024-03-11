package solved.problem1to999._700to799._790to799.customSortString791;

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        int[] characterNumbers = new int[26];
        for (char ch:s.toCharArray()) {
            characterNumbers[ch-'a']++;
        }
        Set<Integer> orderSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch:order.toCharArray()) {
            orderSet.add(ch-'a');
            stringBuilder.append(String.valueOf(ch).repeat(characterNumbers[ch-'a']));
        }
        for (int i=0;i<26;i++) {
            if (!orderSet.contains(i)) {
                stringBuilder.append(String.valueOf((char) ('a' + i)).repeat(characterNumbers[i]));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("cba", "abcd"));
    }
}
