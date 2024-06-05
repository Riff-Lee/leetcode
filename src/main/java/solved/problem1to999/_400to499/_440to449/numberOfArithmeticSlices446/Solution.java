package solved.problem1to999._400to499._440to449.numberOfArithmeticSlices446;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    // can't understand!!!! why ans? solution from leetcode official
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;

    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        int ans = 0;
        for (Map<Long, Integer> map : f) {
            for (Integer num : map.values()) {
                ans+=num;
            }
        }
        return ans-n*(n-1)/2;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[] {0,1,3,5,6,8,12,17}));
    }
}
