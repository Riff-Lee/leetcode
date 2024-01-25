package solved.problem1001to2000._1701to1800.halvesAreAlike1704;

import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int first = 0;
        int second = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (vowels.contains(chars[i])) {
                first++;
            }
        }
        for (int i = chars.length/2; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                second++;
            }
        }
        return first==second;
    }
}
