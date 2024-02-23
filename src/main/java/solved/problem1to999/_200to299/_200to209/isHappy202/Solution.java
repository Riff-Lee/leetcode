package solved.problem1to1000._201to300._201to210.isHappy202;

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        while (n>9){
            int newNum=0;
            while (n!=0){
                int digit=n%10;
                n/=10;
                newNum+=Math.pow(digit,2);

            }
            n=newNum;

        }
        return n==7||n==1;
    }

    public boolean isHappy1(int n) {
        Set<String> set = new HashSet<>();
        String s = String.valueOf(n).replaceAll("0+$", "");

        while (!s.equals("1")) {
            if (set.contains(s)) {
                return false;
            }
            set.add(s);
            int total = 0;
            for (char ch : s.toCharArray()) {
                total+=(ch-'0')*(ch-'0');
            }
            s = String.valueOf(total).replaceAll("0+$", "");
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }
}
