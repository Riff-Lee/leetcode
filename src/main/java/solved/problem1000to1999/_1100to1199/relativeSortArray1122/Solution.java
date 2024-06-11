package solved.problem1000to1999._1100to1199.relativeSortArray1122;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Integer[] arr1Object = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Map<Integer, Integer> sortMap = new HashMap<>();
        for (int i=0;i<arr2.length;i++) {
            sortMap.put(arr2[i],i);
        }
        Arrays.sort(arr1Object, new RelativeComparator(sortMap));
        return Arrays.stream(arr1Object).mapToInt(Integer::intValue).toArray();
    }

    private record RelativeComparator(Map<Integer, Integer> sortMap) implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (sortMap.containsKey(o1) && sortMap.containsKey(o2)) {
                return sortMap.get(o1).compareTo(sortMap.get(o2));
            } else if (sortMap.containsKey(o1)) {
                return -1;
            } else if (sortMap.containsKey(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.asList(solution.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})));
    }
}
