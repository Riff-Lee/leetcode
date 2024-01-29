package solved.problem1001to2000._1701to1800.restoreArray1743;

import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = adjacentPairs.length+1;
        for (int[] adjacentPair : adjacentPairs) {
            for (int num : adjacentPair) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int[] res = new int[n];
        int key = set.stream().findAny().get();
        res[0] = key;
        int i = 1;
        Set<Integer> inc = new HashSet<>();
        inc.add(key);
        while (i<n) {
            List<Integer> values = map.get(key);
            int next=0;
            for (int v : values) {
                if (!inc.contains(v)) {
                    inc.add(v);
                    next = v;
                    break;
                }
            }
            res[i++] = next;
            key = next;
        }


        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreArray(new int[][] {{4,-2},{1,4},{-3,1}}));
    }
}
