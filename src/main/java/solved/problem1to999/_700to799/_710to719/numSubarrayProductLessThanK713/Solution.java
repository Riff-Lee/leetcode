package solved.problem1to999._700to799._710to719.numSubarrayProductLessThanK713;

import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if (k==0){
            return 0;
        }
        int res=0;
        for (int i=0;i<n;i++) {
            if (nums[i]<k) {
                res++;
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=i+1;i<n;i++) {
                
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3},19));
    }
}
