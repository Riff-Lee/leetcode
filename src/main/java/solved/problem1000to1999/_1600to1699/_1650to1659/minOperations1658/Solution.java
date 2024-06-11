package solved.problem1000to1999._1600to1699._1650to1659.minOperations1658;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums, int x) {
        int max = -1;
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum<x) return -1;
        for(int s=0,e=0; e<nums.length; e++) {
            sum -= nums[e];
            while(sum<x) sum += nums[s++];
            if(sum==x && max<(e-s+1)) max = e-s+1;
        }
        return max==-1 ? -1 : nums.length-max;
    }

    public int minOperations1(int[] nums, int x) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i=1;i<n;i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i],-2);
        }
        return help(prefix, dp, nums, 0, n-1, x);
    }

    private int help(int[] prefix, int[][] dp, int[] nums, int i, int j, int x) {
        if (dp[i][j]!=-2){
            return dp[i][j];
        }
        if (x == prefix[j]-prefix[i]+nums[i]) {
            dp[i][j] = j-i+1;
            return dp[i][j];
        }
        if (nums[i] > x && nums[j] > x) {
            dp[i][j]=-1;
            return -1;
        }
        if (nums[i] == x || nums[j] == x) {
            dp[i][j]=1;
            return 1;
        }
        if (i==j) {
            dp[i][j] = -1;
            return -1;
        }
        if (i+1==j) {
            if (nums[i]+nums[j]==x){
                dp[i][j]=2;
                return 2;
            }
            dp[i][j] = -1;
            return -1;
        }
        if (nums[i]>x) {
            if (help(prefix,dp,nums,i,j-1,x-nums[j])<0) {
                dp[i][j] = -1;
                return dp[i][j];
            } else {
                dp[i][j]=help(prefix,dp,nums,i,j-1,x-nums[j])+1;
                return dp[i][j];
            }
        }
        if (nums[j]>x) {
            if (help(prefix,dp,nums,i+1,j,x-nums[i])<0) {
                dp[i][j] = -1;
                return dp[i][j];
            } else {
                dp[i][j]=help(prefix,dp,nums,i+1,j,x-nums[i])+1;
                return dp[i][j];
            }
        }
        int left = help(prefix,dp,nums,i,j-1,x-nums[j]);
        int right = help(prefix,dp,nums,i+1,j,x-nums[i]);
        if (left<0&&right<0) {
            dp[i][j] = -1;
            return dp[i][j];
        }
        if (left<0){
            dp[i][j]=right+1;
            return dp[i][j];
        }
        if (right<0){
            dp[i][j]=left+1;
            return dp[i][j];
        }
        dp[i][j]=Math.min(left,right)+1;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[] {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
    }
}
