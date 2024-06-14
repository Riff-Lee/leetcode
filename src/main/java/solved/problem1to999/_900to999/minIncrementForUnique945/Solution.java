package solved.problem1to999._900to999.minIncrementForUnique945;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    //O(nlogn)
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Set<Integer> set = new HashSet<>();
        int increaseTo = nums[0]+1;
        for (int i:nums) {
            if (set.contains(i)) {
                res+=increaseTo-i;
                set.add(increaseTo++);
            } else {
                increaseTo = i+1;
                set.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minIncrementForUnique(new int[] {1,2,2}));
    }

}
