package solved.problem1to999._400to499.findDuplicates442;

import java.util.*;

class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        boolean[] flag = new boolean[nums.length+1];
        List<Integer> res = new ArrayList<>();
        for (int num:nums) {
            if (flag[num]) {
                res.add(num);
            } else {
                flag[num] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicates(new int[] {0,1,3,5,6,8,12,17}));
    }
}
