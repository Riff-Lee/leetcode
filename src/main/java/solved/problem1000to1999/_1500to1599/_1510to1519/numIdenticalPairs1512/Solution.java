package solved.problem1001to2000._1501to1600._1511to1520.numIdenticalPairs1512;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int res = 0;
        int[] cal = new int[101];
        for (int f : freq) {
            if (f>1) {
                if (cal[f]==0) {
                    cal[f] = f*(f-1)/2;
                }
                res += cal[f];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIdenticalPairs(new int[] {1,1,1,1}));
    }
}
