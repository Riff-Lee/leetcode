package solved.reductionOperations1887;

import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length-1]) {
            return 0;
        }
        int current = 0;
        int times = 0;
        int res = 0;
        for (int num : nums) {
            if (num != nums[0]) {
                if (current != num) {
                    times++;
                    current = num;
                    res += times;
                } else {
                    res += times;
                }
            }
        }

        return res;
    }

}