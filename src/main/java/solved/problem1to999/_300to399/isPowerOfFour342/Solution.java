package solved.problem1to1000._301to400.isPowerOfFour342;

import java.util.*;

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0) {
            return false;
        }
        // Step 2: Check if n is a power of 2
        if ((n & (n - 1)) != 0){
            return false;
        }
        return (n - 1) % 3 == 0;
    }

    public boolean isPowerOfFour1(int n) {
        Set<Integer> set = new HashSet<>();
        int last = 1;
        set.add(last);
        for (int i = 1; i < 16; i++) {
            last*=4;
            set.add(last);
        }
        return set.contains(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
    }
}
