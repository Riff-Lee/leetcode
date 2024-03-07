package solved.problem1to999._1to99._50to59.insert57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = -1;
        boolean startInter = false;
        int end = -1;
        boolean endInter = false;
        int n = intervals.length;
        for (int i=0;i<n;i++) {
            if (intervals[i][0]>newInterval[0]) {
                break;
            }
            start=i;
            if (intervals[i][0]==newInterval[0] || intervals[i][1]>=newInterval[0]) {
                startInter = true;
                break;
            }
        }

        for (int i=0;i<n;i++) {
            if (intervals[i][0]>newInterval[1]) {
                break;
            }
            end=i;
            if (intervals[i][0]==newInterval[1] || intervals[i][1]>=newInterval[1]) {
                endInter = true;
                break;
            }
        }

        if (start==end) {
            if (startInter&&endInter) {
                System.out.println(Arrays.deepToString(intervals));
                return intervals;
            }
            if (startInter) {
                intervals[start][1] = newInterval[1];
                System.out.println(Arrays.deepToString(intervals));
                return intervals;
            }
            int[][] res = new int[n+1][2];
            for (int i=0;i<=start;i++) {
                res[i][0] = intervals[i][0];
                res[i][1] = intervals[i][1];
            }
            res[start+1][0] = newInterval[0];
            res[start+1][1] = newInterval[1];
            for (int i=start+1;i<n;i++) {
                res[i+1][0] = intervals[i][0];
                res[i+1][1] = intervals[i][1];
            }
            System.out.println(Arrays.deepToString(res));
            return res;
        }
        if (startInter) {
            int[][] res = new int[n-end+start][2];
            for (int i=0;i<start;i++) {
                res[i][0] = intervals[i][0];
                res[i][1] = intervals[i][1];
            }
            res[start][0] = intervals[start][0];
            res[start][1] = endInter? intervals[end][1]:newInterval[1];
            for (int i=end+1;i<n;i++) {
                res[++start][0] = intervals[i][0];
                res[start][1] = intervals[i][1];
            }
            System.out.println(Arrays.deepToString(res));
            return res;
        }
        int[][] res = start==-1?new int[n-end][2]:new int[n-end+start+1][2];
        for (int i=0;i<=start;i++) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        res[++start][0] = newInterval[0];
        res[start][1] = endInter? intervals[end][1]:newInterval[1];
        for (int i=end+1;i<n;i++) {
            res[++start][0] = intervals[i][0];
            res[start][1] = intervals[i][1];
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.insert(new int[][]{{4,8},{15,20},{25,30},{35,40},{45,50}},new int[]{6,17}));
    }
}
