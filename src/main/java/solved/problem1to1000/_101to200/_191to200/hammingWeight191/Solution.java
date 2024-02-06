package solved.problem1to1000._101to200._191to200.hammingWeight191;


import java.util.*;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        if (n==Integer.MIN_VALUE) {
            return 32;
        }
        if (n<0) {
            res++;
            n = -n;
        }
        while (n!=0){
            if ((n&1)==1) {
                res++;
            }
            n=n>>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(-2147483645));
    }
}
