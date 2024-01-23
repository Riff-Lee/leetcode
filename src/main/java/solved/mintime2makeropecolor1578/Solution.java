package solved.mintime2makeropecolor1578;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minCost(String colors, int[] neededTime) {
        int index = 0;
        int res = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) != colors.charAt(i-1)) {
                index = i;
            } else {
                if (neededTime[i] < neededTime[index]) {
                    res += neededTime[i];
                } else {
                    res += neededTime[index];
                    index = i;
                }
            }
        }
        return res;
    }

    public int minCost1(String colors, int[] neededTime) {
        List<int[]> sameColors = new ArrayList<>();
        int[] cur = new int[]{-1, -1};
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                if (cur[0] == -1) {
                    cur[0] = i-1;
                }
                cur[1] = i;
            } else if (!Arrays.equals(cur, new int[]{-1, -1})) {
                sameColors.add(cur);
                cur = new int[]{-1, -1};
            }
        }
        if (!Arrays.equals(cur, new int[]{-1, -1})) {
            sameColors.add(cur);
        }
        int res = 0;
        for (int[] index : sameColors) {
            int totalTime = 0;
            int maxTime = 0;
            for (int i = index[0]; i <= index[1]; i++) {
                totalTime += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
            }
            res += totalTime - maxTime;
        }
        return res;
    }

}
