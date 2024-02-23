package solved.problem1001to2000._1701to1800.countHomogenous1759;

class Solution {
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        long count = 0;
        int repeat = 1;
        int mol = 1000000007;
        for (int i=1;i<n;i++) {
            if (chars[i]==chars[i-1]) {
                repeat++;
            } else {
                count=(count+((1+repeat)*(long)repeat/2)) % mol;
                repeat=1;
            }
        }
        count=(count+((1+repeat)*(long)repeat/2)) % mol;
        return (int)count;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHomogenous("a"));
    }
}
