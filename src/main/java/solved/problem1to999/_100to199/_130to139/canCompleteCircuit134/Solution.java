package solved.problem1to1000._101to200._131to140.canCompleteCircuit134;

import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tg=0;
        int tc=0;
        for(int i=0;i<gas.length;i++){
            tg = tg + gas[i];
            tc = tc + cost[i];
        }
        if(tg<tc)
            return -1;
        int diff = 0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            diff = diff + gas[i] - cost[i];
            if(diff<0){
                diff=0;
                start = i+1;
            }
        }
        return start;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remains = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            remains[i] = gas[i]-cost[i];
            total+=remains[i];
        }
        if (total<0) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (remains[i]<0||gas[i]==0) {
                continue;
            }
            int j=0;
            int remainGas = 0;
            while (j<n) {
                int index = i+j;
                if (index>=n) {
                    index = index-n;
                }
                remainGas += remains[index];
                if (remainGas<0) {
                    break;
                }
                if (j==n-1){
                    return i;
                }
                j++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
    }
}
