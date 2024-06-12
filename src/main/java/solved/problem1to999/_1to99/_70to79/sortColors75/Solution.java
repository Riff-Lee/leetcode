package solved.problem1to999._1to99._70to79.sortColors75;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        for (int n:nums) {
            switch (n) {
                case 0 -> zero++;
                case 1 -> one++;
            }
        }
        for (int i=0;i<zero;i++) {
            nums[i]=0;
        }
        for (int i=zero;i<zero+one;i++) {
            nums[i]=1;
        }
        for (int i=zero+one;i<nums.length;i++) {
            nums[i]=2;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors(new int[] {2,0,2,1,1,0});

    }
}
