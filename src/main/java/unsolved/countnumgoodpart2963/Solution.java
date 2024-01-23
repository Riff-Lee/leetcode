package unsolved.countnumgoodpart2963;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mol = 1000000007;

        int[] dp = new int[nums.length];
        dp[0] = 1;

        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int index = indexMap.get(nums[i]);
                dp[i] = dp[index];
            } else {
                indexMap.put(nums[i], i);
                dp[i] = (2 * dp[i-1]) % mol;
            }
        }
        return dp[nums.length-1];
    }

}
