package solved.problem2000to2999._2100to2199.sortJumbled2191;

import java.util.*;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> mappedValue = new HashMap<>();
        PriorityQueue<Integer> newNums = new PriorityQueue<>();
        for (int num : nums) {
            if (num == 0) {
                if (!mappedValue.containsKey(mapping[0])) {
                    mappedValue.put(mapping[0], new ArrayList<>());
                    newNums.add(mapping[0]);
                }
                mappedValue.get(mapping[0]).add(num);
                continue;
            }
            int current = num;
            int i = 1;
            int newNum = 0;
            while (current > 0) {
                int a = current % 10;
                newNum += i * mapping[a];
                current = current / 10;
                i *= 10;
            }
            if (!mappedValue.containsKey(newNum)) {
                mappedValue.put(newNum, new ArrayList<>());
                newNums.add(newNum);
            }
            mappedValue.get(newNum).add(num);

        }
        int[] res = new int[nums.length];
        int i=0;
        while (!newNums.isEmpty()) {
            for (int dig : mappedValue.get(newNums.poll())) {
                res[i++] = dig;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9});
    }


}
