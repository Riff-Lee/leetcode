package solved.elimimaxnum1921;

import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) dist[i] / (double) speed[i];
        }
        Arrays.sort(time);
        int num = 1;
        for (int i = 1; i < n; i++) {
            if (time[i] > i) {
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
