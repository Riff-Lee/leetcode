package solved.problem1000to1999._1700to1799._1750to1759.minimumLength1750;

class Solution {
    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n==1) {
            return 1;
        }
        int left = 0;
        int right = n-1;
        while (left<right) {
            if (chars[left]!=chars[right]) {
                break;
            }
            if (left==right-1) {
                return 0;
            }
            int i=left;
            for (;i<right;i++) {
                if (chars[i]!=chars[left]) {
                    break;
                }
            }
            left=i;
            int j=right;
            for (;j>=left;j--) {
                if (chars[j]!=chars[right]) {
                    break;
                }
            }
            right=j;
        }

        return right-left+1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("abbbbbbbbbbbbbbbbbbba"));
    }
}
