package solved.problem1to999._200to299.wordPattern290;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != words.length) {
            return false;
        }
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        int n = chars.length;
        for (int i=0;i<n;i++) {
            if (map[chars[i]-'a']==null) {
                if (set.contains(words[i])) {
                    return false;
                }
                map[chars[i]-'a'] = words[i];
                set.add(words[i]);
            } else {
                if (!map[chars[i]-'a'].equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
}
