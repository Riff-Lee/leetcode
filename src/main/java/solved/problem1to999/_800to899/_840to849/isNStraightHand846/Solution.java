package solved.problem1to999._800to899._840to849.isNStraightHand846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int size = hand.length;
        if (size%groupSize!=0) {
            return false;
        }
        if (groupSize==1) {
            return true;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : hand) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num)+1);
            } else {
                countMap.put(num, 1);
            }
        }
        int[] numSet = countMap.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(numSet);
        for (int min : numSet) {
            int minCount = countMap.get(min);
            if (minCount>0) {
                for (int i=1;i<groupSize;i++) {
                    int nextCount = countMap.getOrDefault(min+i, 0);
                    if (nextCount<minCount) {
                        return false;
                    }
                    countMap.put(min+i, nextCount-minCount);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8},3));
    }
}
