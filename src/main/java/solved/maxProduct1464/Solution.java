package solved.maxProduct1464;

class Solution {
    public int maxProduct(int[] nums) {
        int i = Math.max(nums[0], nums[1]);
        int j = Math.min(nums[0], nums[1]);
        for (int m = 2; m < nums.length; m++) {
            if (nums[m] <= j) {
                continue;
            }
            if (nums[m] <= i) {
                j = nums[m];
                continue;
            }
            j = i;
            i = nums[m];
        }
        return (i-1) * (j-1);
    }
}
