package solved.problem1001to2000._1701to1800.totalMoney1716;

import java.util.*;

class Solution {
    public int totalMoney(int n) {
        int mol = n%7;
        int div = n/7;
        return div*(div-1)/2*7+(1+mol)*mol/2+mol*div+div*28;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(10));
    }
}
