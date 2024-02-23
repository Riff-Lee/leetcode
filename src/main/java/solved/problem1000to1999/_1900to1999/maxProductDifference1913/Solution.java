package solved.problem1001to2000._1901to2000.maxProductDifference1913;

class Solution {
    public int maxProductDifference(int[] nums) {
        int max1 = -1;
        int max2 = -2;
        int min1 = 100000001;
        int min2 = 100000002;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return max1*max2 - min1*min2;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProductDifference(new int[] {4,2,5,9,7,4,8}));
    }
}
