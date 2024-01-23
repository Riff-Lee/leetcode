package solved.minTaps1326;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //greedy
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 0);

        for(int i = 0; i < ranges.length; i++) {
            if(ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int end = 0;
        int far_can_reach = 0;
        int cnt = 0;
        for(int i = 0; i <= n; i++) {
            if(i > end) {
                if(end >= far_can_reach) return -1;
                end = far_can_reach;
                cnt++;
            }
            far_can_reach = Math.max(far_can_reach, arr[i]);
        }

        return cnt + (end < n ? 1 : 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minTaps(35, new int[] {1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2}));
    }
}
