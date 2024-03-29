package solved.problem1to999._100to199._170to179.titleToNumber171;


public class Solution {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        int n = chars.length;
        for (int i=0;i<n;i++) {
            res+=(chars[i]-'A'+1)*Math.pow(26,n-i-1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("A"));
    }
}
