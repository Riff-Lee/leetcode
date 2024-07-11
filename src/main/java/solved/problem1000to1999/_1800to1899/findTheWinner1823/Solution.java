package solved.problem1000to1999._1800to1899.findTheWinner1823;

import java.util.Arrays;

class Solution {

    public int findTheWinner(int n, int k) {
        int winner=0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5,2));
    }
}
