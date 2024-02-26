package solved.problem1to999._1to99._80to89.removeDuplicates80;

class Solution {
    public int removeDuplicates(int[] nums) {
        int times = 1;
        int lastValue = nums[0];
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (lastValue==nums[i]) {
                times++;
                if (times>2) {
                    offset++;
                }
            } else {
                times=1;
                lastValue = nums[i];
            }
            nums[i-offset] = nums[i];
        }
        return nums.length-offset;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1,2,2,3}));

    }
}
