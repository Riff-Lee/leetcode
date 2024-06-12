package solved.problem3000to3999._3000to3099.maxSelectedElements3041;


import java.util.Arrays;

public class Solution {

    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int a = 1;
        int b = 1;
        int ans = 1;
        for(int i=1;i<n;i++) {
            int c = nums[i] == nums[i-1] + 1 ? 1 + a : (nums[i] == nums[i-1] + 2 ? 1 + b : (nums[i] == nums[i-1]) ? a : 1);
            int d = nums[i] == nums[i-1] ? 1 + a : (nums[i] == nums[i-1] + 1 ? 1 + b : 1);
            a = c;
            b = d;
            ans = Math.max(ans, Math.max(a, b));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSelectedElements(new int[] {12,11,8,7,2,10,18,12}));
    }
}
