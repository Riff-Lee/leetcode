package solved.problem1to999._1to99._50to59.merge56;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int[] interval:intervals) {
            if (interval[0] > right) {
                list.add(new int[]{left,right});
                left = interval[0];
                right = interval[1];
            } else {
                if (interval[1]>right) {
                    right = interval[1];
                }
            }
        }
        list.add(new int[]{left,right});
        int[][] res = new int[list.size()][2];
        for (int i=0;i<list.size();i++) {
            res[i]=list.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.merge(new int[][]{{4,5},{2,6},{8,10}}));
    }
}
