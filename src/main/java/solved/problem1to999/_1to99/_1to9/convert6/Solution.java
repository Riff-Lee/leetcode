package solved.problem1to999._1to99._1to9.convert6;

class Solution {
    public String convert(String s, int numRows) {

        int groupNum = numRows==1?1:2*numRows-2;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); j+=groupNum) {
            sb.append(chars[j]);
        }
        for (int i=1;i<numRows && i<s.length();i++) {
            sb.append(chars[i]);
            for (int j = groupNum; j < s.length()+groupNum; j+=groupNum) {
                if (j-i>j-groupNum+numRows-1 && j-i<s.length()) {
                    sb.append(chars[j-i]);
                }
                if (j+i<s.length()) {
                    sb.append(chars[j+i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCD",3));
    }
}
