package solved.problem1to1000._101to200._191to200.rob198;


public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) {
            return nums[0];
        }
        if (n==2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[] {1,2,3,1}));
    }
}
