package solved.problem1to1000._401to500.canCross403;

import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        if (stones.length == 2) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, Set.of(1));
        for (int i = 1; i < stones.length - 1; i++) {
            if (!map.containsKey(stones[i])) {
                continue;
            }
            Set<Integer> steps = map.get(stones[i]);
            for (Integer step : steps) {
                if (step != 1) {
                    map.computeIfAbsent(stones[i] - 1 + step, k-> new HashSet<>()).add(step - 1);
                }
                map.computeIfAbsent(stones[i] + step, k-> new HashSet<>()).add(step);
                map.computeIfAbsent(stones[i] + 1 + step, k-> new HashSet<>()).add(step + 1);
            }
        }
        return map.containsKey(stones[stones.length - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(new int[] {0,1,3,5,6,8,12,17}));
    }
}
