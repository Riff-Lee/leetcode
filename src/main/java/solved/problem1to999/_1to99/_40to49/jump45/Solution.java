package solved.problem1to999._1to99._40to49.jump45;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] jump = new int[n];
        jump[n-1] = 0;
        for (int i = n-2; i>=0; i--) {
            if (nums[i]+i>=n-1) {
                jump[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j=1; j<=nums[i]; j++) {
                    if (jump[j+i] > 0) {
                        min = Math.min(jump[j+i], min);
                    }
                }
                jump[i] = min==Integer.MAX_VALUE ? 0 : min+1;
            }
        }
        return jump[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[] {2,3,1,1,4}));
    }
}
