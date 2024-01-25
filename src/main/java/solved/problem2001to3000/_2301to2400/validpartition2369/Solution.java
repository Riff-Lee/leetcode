package solved.problem2001to3000._2301to2400.validpartition2369;

import java.util.Arrays;

public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 0;
        dp[n-2] = is2Equal(n-2, nums) ? 1 : 0;
        for (int i = n-3; i >=0; i--) {
            dp[i] = is2Equal(i, nums) && dp[i+2] == 1 ? 1 : 0;
            if (dp[i] == 0) {
                dp[i] = (is3Equal(i, nums) || is3Consecutive(i, nums)) && dp[i+3] == 1 ? 1 : 0;
            }
        }
        return dp[0] == 1;
    }
    private boolean is2Equal(int index, int[] nums) {
        return nums[index] == nums[index+1];
    }
    private boolean is3Equal(int index, int[] nums) {
        return nums[index] == nums[index+1] && nums[index] == nums[index+2];
    }
    private boolean is3Consecutive(int index, int[] nums) {
        return nums[index] + 1 == nums[index+1] && nums[index] + 2 == nums[index+2];
    }

}
