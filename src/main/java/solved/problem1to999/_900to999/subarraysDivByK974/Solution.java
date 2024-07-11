package solved.problem1to999._900to999.subarraysDivByK974;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int preSum = 0;
        int res =0;
        int[] mods = new int[k];
        mods[0] = 1;
        for (int num : nums) {
            preSum += num;
            int mod = preSum%k;
            if (mod<0) {
                mod+=k;
            }
            res += mods[mod];
            mods[mod]++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(new int[] {4,5,0,-2,-3,1},5));
    }

}
