package solved.problem1to1000._801to900.isMonotonic896;

import java.util.*;

class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        int i = 1;
        for (;i<nums.length;i++) {
            if (nums[i-1]!=nums[i]) {
                break;
            }
        }
        if (i==nums.length) {
            return true;
        }
        boolean increase = nums[i-1] <= nums[i];
        for (;i<nums.length;i++) {
            if (nums[i-1]!=nums[i]&&increase!=(nums[i-1]<nums[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(new int[] {1,1,1}));
    }
}
