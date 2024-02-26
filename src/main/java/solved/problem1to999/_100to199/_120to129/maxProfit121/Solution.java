package solved.problem1to999._100to199._120to129.maxProfit121;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] suffix = new int[n];
        suffix[n-1] = prices[n-1];
        for (int i = n-2; i>=0; i--) {
            suffix[i] = Math.max(suffix[i+1], prices[i]);
        }
        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(suffix[i]-prices[i], max);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {1}));
    }
}
