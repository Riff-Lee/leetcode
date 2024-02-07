package solved.problem1to1000._1to100._21to30.removeElement27;


public class Solution {
    public int removeElement(int[] nums, int val) {

        int k=0;
        for (int num:nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[] {3,2,2,3}, 3));
    }
}
