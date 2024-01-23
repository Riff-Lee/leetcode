package solved.uniqueOccurrences1207;


import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> times = new HashMap<>();
        for (int num : arr) {
            times.computeIfPresent(num, (k,v) -> v+1);
            times.putIfAbsent(num, 1);
        }
        int size = times.values().size();
        int uniqueSize = (int) times.values().stream().distinct().count();
        return size == uniqueSize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[] {1,2}));
    }
}
