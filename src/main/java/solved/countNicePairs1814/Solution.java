package solved.countNicePairs1814;

import java.util.Arrays;

class Solution {

    public int countNicePairs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - reverse(nums[i]);
        }
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long count = 1;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }
            res = (res % mod + (count * (count - 1)) / 2) % mod;
        }

        return (int) (res % mod);
    }
    private int reverse (int num) {
        int reversedNum = 0;

        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countNicePairs(new int[] {442111244,357716602,131050131,251794140,4046404,373969224,1082801,468525864,384140537,492968345}));
    }
}
