package solved.problem1to1000._1to100._11to20.intToRoman12;

import java.util.*;

class Solution {

    public String intToRoman(int num) {
        String res = "";
        int m = num / 1000;
        res = res + "M".repeat(m);
        num = num % 1000;
        if (num >= 900) {
            res = res + "CM";
            num = num - 900;
        }
        int d = num / 500;
        res = res + "D".repeat(d);
        num = num % 500;
        if (num >= 400) {
            res = res + "CD";
            num = num - 400;
        }
        int c = num / 100;
        res = res + "C".repeat(c);
        num = num % 100;
        if (num >= 90) {
            res = res + "XC";
            num = num - 90;
        }
        int l = num / 50;
        res = res + "L".repeat(l);
        num = num % 50;
        if (num >= 40) {
            res = res + "XL";
            num = num - 40;
        }
        int x = num / 10;
        res = res + "X".repeat(x);
        num = num % 10;
        if (num >= 9) {
            res = res + "IX";
            num = num - 9;
        }
        int v = num / 5;
        res = res + "V".repeat(v);
        num = num % 5;
        if (num >= 4) {
            res = res + "IV";
            num = num - 4;
        }
        res = res + "I".repeat(num);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
    }
}
