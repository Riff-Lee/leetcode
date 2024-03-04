package solved.problem1to999._200to299.containsNearbyDuplicate219;

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int i=0;
        for (;i<=k&&i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        if (i<k) {
            return false;
        }
        set.remove(nums[0]);
        for (;i<nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.remove(nums[i-k]);
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{4,1,2,3,1,5},3));
    }
}
