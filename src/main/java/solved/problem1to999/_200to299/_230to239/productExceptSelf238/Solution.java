package solved.problem1to999._200to299._230to239.productExceptSelf238;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i=1;i<n;i++) {
            prefix[i] = prefix[i-1]*nums[i];
        }
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for (int i=n-2;i>=0;i--) {
            suffix[i] = suffix[i+1]*nums[i];
        }
        int[] answer = new int[n];
        answer[0] = suffix[1];
        answer[n-1] = prefix[n-2];
        for (int i=1;i<n-1;i++) {
            answer[i] = prefix[i-1]*suffix[i+1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.productExceptSelf(new int[] {1,2,3,4}));
    }
}
