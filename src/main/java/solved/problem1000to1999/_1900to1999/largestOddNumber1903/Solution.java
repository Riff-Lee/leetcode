package solved.problem1001to2000._1901to2000.largestOddNumber1903;

import java.util.Set;

class Solution {
    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int i=num.length()-1;
        for (;i>=0;i--) {
            if (Set.of('1','3','5','7','9').contains(chars[i])) {
                break;
            }
        }
        return num.substring(0,i+1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("1"));
    }
}
