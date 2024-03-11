package solved.problem3000to3999._3000to3099._3000to3009.maxFrequencyElements3005;


public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] mem=new int[101];
        int max=0;
        for (int num:nums) {
            max =Math.max(max, ++mem[num]);
        }
        int sum=0;
        for (int i:mem) {
            if (i==max) {
                sum+=i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxFrequencyElements(new int[] {4}));
    }
}
