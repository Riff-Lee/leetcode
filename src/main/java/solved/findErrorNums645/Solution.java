package solved.findErrorNums645;

import java.util.Arrays;

class Solution {



    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                missing = i;
            }
        }

        return new int[] {dup, missing};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findErrorNums(new int[] {1,5,3,2,2,7,6,4,8,9}));
    }
}
