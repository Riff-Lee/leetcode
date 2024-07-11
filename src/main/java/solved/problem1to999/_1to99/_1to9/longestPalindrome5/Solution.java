package solved.problem1to999._1to99._1to9.longestPalindrome5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String longestPalindrome(String s) {

        char[] orgChars = s.toCharArray();
        char[] chars = new char[orgChars.length*2+3];
        chars[0] = '^';
        chars[chars.length-2] = '#';
        chars[chars.length-1] = '$';
        for (int i=0;i<orgChars.length;i++) {
            chars[2*i+1] = '#';
            chars[2*i+2] = orgChars[i];
        }
        int[] palindrome = new int[chars.length];
        int center = 0;
        int right = 0;
        for (int i=0; i<chars.length; i++) {
            if (i < right) {
                palindrome[i] = Math.min(right-i, palindrome[2*center-i]);
            }
            while (i-palindrome[i]-1>=0 && i+palindrome[i]+1<chars.length && chars[i-palindrome[i]-1] == chars[i+palindrome[i]+1]) {
                palindrome[i]++;
            }
            if (palindrome[i]+i > right) {
                center = i;
                right = palindrome[i]+i;
            }
        }
        int maxIndex = 0;
        for (int i=0; i<chars.length; i++) {
            maxIndex = palindrome[i] > palindrome[maxIndex] ? i : maxIndex;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=maxIndex-palindrome[maxIndex];i<=maxIndex+palindrome[maxIndex];i++) {
            if (chars[i]!='^'&&chars[i]!='#'&&chars[i]!='$') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
