package solved.problem2001to3000._2201to2300.findWinners2225;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winnersSet = new HashSet<>();
        Set<Integer> losersOnceSet = new HashSet<>();
        int[] loseTimes = new int[100001];
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            loseTimes[loser] = loseTimes[loser] + 1;
            if (loseTimes[winner] == 0) {
                winnersSet.add(winner);
            }
            if (loseTimes[loser] == 1) {
                losersOnceSet.add(loser);
            } else if (loseTimes[loser] > 1) {
                losersOnceSet.remove(loser);
            }
            winnersSet.remove(loser);

        }
        List<Integer> winners = winnersSet.stream().sorted().collect(Collectors.toList());
        List<Integer> losersOnce = losersOnceSet.stream().sorted().collect(Collectors.toList());
        return List.of(winners, losersOnce);
    }
    public List<List<Integer>> findWinners1(int[][] matches) {
        List<Integer> winners = new ArrayList<>();
        List<Integer> losersOnce = new ArrayList<>();
        int[][] wlTimes = new int[100001][2];
        Set<Integer> candidates = new HashSet<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            wlTimes[winner][0] = wlTimes[winner][0] + 1;
            wlTimes[loser][1] = wlTimes[loser][1] + 1;
            candidates.add(winner);
            candidates.add(loser);
        }
        for (int c : candidates) {
            if (wlTimes[c][1] == 1) {
                losersOnce.add(c);
            } else if (wlTimes[c][0] > 0 && wlTimes[c][1] == 0) {
                winners.add(c);
            }
        }
        winners = winners.stream().sorted().collect(Collectors.toList());
        losersOnce = losersOnce.stream().sorted().collect(Collectors.toList());
        return List.of(winners, losersOnce);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWinners(new int[][] {{1,3}, {2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}}));
    }
}
