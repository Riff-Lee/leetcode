package solved.problem1to999._100to199.rotate189;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k>n)
            k=k%n;
        rotatehelper(nums, 0, n-1);
        rotatehelper(nums, 0, k-1);
        rotatehelper(nums, k, n-1);
    }

    public void rotatehelper(int[] nums, int sp,int ep) {
        while(sp<ep){
            int temp=nums[sp];
            nums[sp]=nums[ep];
            nums[ep]=temp;
            sp++;
            ep--;
        }
    }

    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        if (k>=n) {
            k = k % n;
        }
        if (n==1 || k ==0) {
            return;
        }
        int sign = k;
        for (int num : Arrays.stream(nums).toArray()) {
            if (sign == n) {
                sign = 0;
            }
            nums[sign++] = num;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[] {-1}, 2);
    }
}
