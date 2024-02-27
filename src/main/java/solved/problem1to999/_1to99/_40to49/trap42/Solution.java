package solved.problem1to999._1to99._40to49.trap42;

import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        int res = 0;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            res += Math.max(0,Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
