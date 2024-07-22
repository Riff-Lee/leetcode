package solved.problem2000to2999._2400to2499.sortPeople2418;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        People[] peoples = new People[names.length];
        for (int i=0;i<names.length;i++) {
            peoples[i] = new People(names[i], heights[i]);
        }
        Arrays.sort(peoples, (o1, o2) -> Integer.compare(o2.height, o1.height));
        String[] res = new String[names.length];
        for (int i=0;i<names.length;i++) {
            res[i] = peoples[i].name;
        }
        return res;
    }

    static class People {
        String name;
        int height;
        People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.sortPeople(new String[]{"Mary","John","Emma"},new int[] {180,165,170});
        System.out.println(res);
    }
}
