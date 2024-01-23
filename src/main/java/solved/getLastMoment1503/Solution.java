package solved.getLastMoment1503;

import java.util.Set;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;
        for (int l : left) {
            leftMax = Math.max(leftMax, l);
        }

        int rightMin = n;
        for (int r : right) {
            rightMin = Math.min(rightMin, r);
        }

        return Math.max(leftMax, n - rightMin) ;
    }
}
