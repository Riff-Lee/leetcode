package solved.problem2000to2999._2800to2899.maximumOddBinaryNumber2864;


public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeros = 0;
        for (char ch:s.toCharArray()) {
            if (ch=='0') {
                zeros++;
            } else {
                ones++;
            }
        }
        ones--;
        return "1".repeat(ones)+"0".repeat(zeros)+"1";
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumOddBinaryNumber("1"));
    }
}
