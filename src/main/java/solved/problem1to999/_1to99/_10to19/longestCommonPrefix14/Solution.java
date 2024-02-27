package solved.problem1to999._1to99._10to19.longestCommonPrefix14;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        int n = strs[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++) {
            char ch = strs[0].charAt(i);
            for (String s:strs) {
                if (i>=s.length() || s.charAt(i)!=ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}
