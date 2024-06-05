package solved.problem1000to1999._1000to1099.commonChars1002;

import java.util.ArrayList;
import java.util.List;


class Solution {

    public List<String> commonChars(String[] words) {
        int[] charNum = new int[26];
        char[] initial = words[0].toCharArray();
        for (char ch : initial) {
            charNum[ch-'a']++;
        }
        for (int i=1;i<words.length;i++) {
            char[] next = words[i].toCharArray();
            int[] nextNum = new int[26];
            for (char ch : next) {
                nextNum[ch-'a']++;
            }
            for (int a=0;a<26;a++) {
                if (charNum[a]>nextNum[a]) {
                    charNum[a]=nextNum[a];
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int a=0;a<26;a++) {
            if (charNum[a]>0) {
                for (int n=0;n<charNum[a];n++) {
                    res.add(Character.toString('a'+a));
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"bella","label","roller"}));
    }
}
