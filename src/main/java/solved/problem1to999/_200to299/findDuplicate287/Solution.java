package solved.problem1to1000._201to300.findDuplicate287;

import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                duplicate = idx;
                break;
            }
            nums[idx] = -nums[idx];
        }

        return duplicate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[] {1,3,4,2,2}));
    }
}
