package solved.problem1to1000._201to300.missingNumber268;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int eor = n;
        for (int i=0;i<n;i++) {
            eor=eor^i^nums[i];
        }
        return eor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[] {1}));
    }
}
