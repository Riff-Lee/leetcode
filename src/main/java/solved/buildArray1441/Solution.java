package solved.buildArray1441;

import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();

        int index = 0;
        for (int i=1; i<=target[target.length-1]; i++) {
            res.add("Push");
            if (target[index] == i) {
                index++;
            } else {
                res.add("Pop");
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buildArray(new int[] {1,3}, 3));
    }
}
