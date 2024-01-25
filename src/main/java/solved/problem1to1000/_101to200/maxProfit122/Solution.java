package solved.problem1to1000._101to200.maxProfit122;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            res += Math.max(diff, 0);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
