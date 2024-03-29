package solved.problem1to1000._301to400.isSubsequence392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i = 0;
        int j = 0;
        while (i<sChars.length && j< tChars.length) {
            if (sChars[i]==tChars[j]) {
                i++;
            }
            j++;
        }
        return i == sChars.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
    }
}
