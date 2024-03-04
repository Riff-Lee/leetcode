package solved.problem1to999._200to299._200to209.minSubArrayLen209;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum=0;
        for (int right=0;right<nums.length;right++) {
            sum+=nums[right];
            while (sum>=target) {
                minLength=Math.min(minLength,right-left+1);
                sum-=nums[left++];
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
