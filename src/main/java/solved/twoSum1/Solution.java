package solved.twoSum1;

import java.util.*;

class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.putIfAbsent(target - nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[] {i, j};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[] {2,7,11,15}, 9));
    }
}
