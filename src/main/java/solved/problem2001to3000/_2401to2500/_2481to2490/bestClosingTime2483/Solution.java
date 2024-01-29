package solved.problem2001to3000._2401to2500._2481to2490.bestClosingTime2483;


public class Solution {
    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int n = chars.length;
        int[] Y = new int[n];
        Y[0] = chars[0] == 'Y' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            Y[i] = Y[i-1] + (chars[i] == 'Y' ? 1 : 0);
        }
        int min = Y[n-1];
        int minIndex = 0;
        for (int i = 1; i <= n; i++) {
            int penalty = i - Y[i-1] + Y[n-1] - Y[i-1];
            if (penalty<min) {
                min = penalty;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYNY"));
    }
}
