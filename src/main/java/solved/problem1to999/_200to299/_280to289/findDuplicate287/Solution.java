package solved.problem1to999._200to299._280to289.findDuplicate287;

class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                duplicate = idx;
                break;
            }
            nums[idx] = -nums[idx];
        }

        return duplicate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[] {1,3,4,2,2}));
    }
}
