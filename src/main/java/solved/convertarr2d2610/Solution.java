package solved.convertarr2d2610;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dp = new int[nums.length+1];
        for (int num : nums) {
            if (dp[num] >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(dp[num]).add(num);
            dp[num]++;
        }
        return res;
    }

    public List<List<Integer>> findMatrix1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        int maxNum = nums[0];
        for (int num : nums) {
            numMap.computeIfPresent(num, (k,v) -> v + 1);
            numMap.putIfAbsent(num, 1);
            maxNum = numMap.get(maxNum) > numMap.get(num) ? maxNum : num;
        }
        int max = numMap.get(maxNum);
        for (int i = 1; i <= max; i++) {
            List<Integer> col = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
                if (entry.getValue() > 0) {
                    col.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                }
            }
            res.add(col);
        }
        return res;
    }

}
