package solved.problem2001to3000._2901to3000.divideArray2966;


import java.util.Arrays;

public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int div = nums.length / 3;
        int[][] res = new int[div][3];
        for (int i = 0,start=0; i < div; i++,start=start+3) {
            if (nums[start+2] - nums[start] > k) {
                return new int[][]{};
            }
            res[i][0] = nums[start];
            res[i][1] = nums[start+1];
            res[i][2] = nums[start+2];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divideArray(new int[] {1,3,4,8,7,9,3,5,1}, 2));
    }
}
