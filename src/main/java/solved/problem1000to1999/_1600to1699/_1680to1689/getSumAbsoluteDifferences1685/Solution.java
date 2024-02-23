package solved.problem1001to2000._1601to1700._1681to1690.getSumAbsoluteDifferences1685;

import java.util.*;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (2*i+2-n)*nums[i]+prefixSum[n-1]-2*prefixSum[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSumAbsoluteDifferences(new int[] {1,4,6,8,10}));
    }
}
