package solved.problem1to999._1to99._20to29.removeDuplicates26;


import java.util.*;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] {1,1,2}));
    }
}
