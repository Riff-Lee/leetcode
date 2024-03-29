package solved.problem1to999._1to99._40to49.firstMissingPositive41;

import java.util.*;

class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each positive integer i at index i-1 if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        boolean[] mem = new boolean[n+1];
        for (int num: nums) {
            if (num<=n && num>0) {
                mem[num]=true;
            }
        }
        int i=1;
        for (;i<n+1;i++) {
            if (!mem[i]) {
                return i;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[] {1}));
    }
}
