package solved.problem1to999._400to499.findMinArrowShots452;

import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int arrows = 1;
        int left = points[0][0];
        int right = points[0][1];
        for (int[] point : points) {
            if (point[0] <= right) {
                left = Math.max(left, point[0]);
                right = Math.min(right, point[1]);
            } else {
                left = point[0];
                right = point[1];
                arrows++;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][] {{-2147483648,2147483647}}));
    }
}
