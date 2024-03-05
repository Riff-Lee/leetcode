package solved.problem1000to1999._1700to1799._1750to1759.minOperations1758;

class Solution {
    public int minOperations(String s) {
        int chgNum = 0;
        char startChar = '0';
        for (char ch : s.toCharArray()) {
            if (ch == startChar) {
                chgNum++;
            }
            startChar = startChar == '0' ? '1' : '0';
        }
        return Math.min(chgNum, s.length()-chgNum);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations("0100"));
    }
}
