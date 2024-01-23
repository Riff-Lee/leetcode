package solved.minnumofopr2emptyarr2870;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.computeIfPresent(num, (k,v) -> v+1);
            numMap.putIfAbsent(num, 1);
        }
        int res = 0;
        for (Integer value : numMap.values()) {
            if (value == 1) {
                res = -1;
                break;
            }
            if (value % 3 == 0) {
                res += value / 3;
            } else {
                res += value / 3 + 1;
            }
        }
        return res;
    }
}
