package solved.problem1to1000._201to300._201to210.rangeBitwiseAnd201;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (right>left) {
            right&=(right-1);
        }
        return right;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(4,7));
    }
}
