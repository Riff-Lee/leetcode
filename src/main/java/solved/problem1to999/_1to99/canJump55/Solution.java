package solved.problem1to999._1to99.canJump55;

class Solution {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n];
        canJump[n-1] = true;
        for (int i = n-2; i>=0; i--) {
            if (nums[i]+i >= n-1) {
                canJump[i] = true;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    if (canJump[j+i]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[] {2,5,0,0}));
    }
}
