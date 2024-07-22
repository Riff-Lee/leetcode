package solved.problem1to999._900to999.findJudge997;


import java.util.*;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n==1) {
            return trust.length == 0 ? 1:-1;
        }

        Set<Integer> hasTrusts = new HashSet<>();
        Map<Integer, Set<Integer>> trustMap = new HashMap<>();
        for (int[] t : trust) {
            hasTrusts.add(t[0]);
            if (!trustMap.containsKey(t[1])) {
                trustMap.put(t[1], new HashSet<>());
            }
            trustMap.get(t[1]).add(t[0]);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : trustMap.entrySet()) {
            if (hasTrusts.contains(entry.getKey())) {
                continue;
            }
            if (entry.getValue().size() == n-1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findJudge(2, new int[][] {{1,2}}));
    }

}
