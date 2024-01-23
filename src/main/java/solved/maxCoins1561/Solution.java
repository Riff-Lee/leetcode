package solved.maxCoins1561;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int res = 0;
        for (int i = n; i < piles.length; i=i+2) {
            res += piles[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[] {9,8,7,6,5,1,2,3,4}));
    }
}
