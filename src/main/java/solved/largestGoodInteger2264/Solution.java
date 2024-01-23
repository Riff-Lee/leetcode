package solved.largestGoodInteger2264;

class Solution {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        int max = -1;
        for (int i = 0; i < chars.length-2; i++) {
            if (chars[i] == chars[i+1] && chars[i+1] == chars[i+2]) {
                max = Math.max(max, chars[i]-48);
            }
        }
        return max == -1 ? "" : String.valueOf(max).repeat(3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger("6777133339"));
    }
}
