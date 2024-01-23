package unsolved.combinationSum4377;

import java.util.Arrays;

class Solution {
    int dp[][];
    public int combinationSum4(int[] nums, int target) {
        dp = new int[nums.length][target+1];
        Arrays.sort(nums);
        for (int[] col : dp) {
            Arrays.fill(col, -1);
        }
        return sol(nums, nums.length - 1, target);
    }

    private int sol(int[] nums, int i, int target) {
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if (i == 0) {
            dp[i][target] = target%nums[0] == 0 ? 1 : 0;
            return dp[i][target];
        }
        if (target == nums[0]) {
            dp[i][target] = 1;
            return dp[i][target];
        }
        if (target < nums[0]) {
            dp[i][target] = 0;
            return dp[i][target];
        }
        return target - nums[i] < 0 ? sol(nums, i-1, target) : sol(nums, i-1, target) + sol(nums, i-1, target - nums[i]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum4(new int[] {1,2,3}, 4));
    }
}
