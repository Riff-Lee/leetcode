package solved.problem1001to2000._1201to1300.sequentialDigits1291;

import java.util.*;

class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int digit = 1; digit < 9; ++digit) {
            int next = digit, n = next;
            while (n <= high && next < 10) {
                if (n >= low) {
                    res.add(n);
                }
                n = n * 10 + ++next;
            }
        }
        Collections.sort(res);
        return res;
    }

    public List<Integer> sequentialDigits1(int low, int high) {
        int minBit = String.valueOf(low).length();
        int maxBit = String.valueOf(high).length();
        String num = "123456789";
        List<Integer> res = new ArrayList<>();
        int min = low / Integer.parseInt("1"+"0".repeat(minBit-1));
        int max = high / Integer.parseInt("1"+"0".repeat(maxBit-1));
        if (minBit==maxBit) {
            if (min - 1 + maxBit <= 9) {
                int minNum = Integer.parseInt(num.substring(min - 1, min - 1 + minBit));
                if (minNum >= low && minNum <= high) {
                    res.add(minNum);
                }
            }
            for (int i=min+1; i<max&&i-1+minBit<=9; i++) {
                res.add(Integer.parseInt(num.substring(i-1, i-1+minBit)));
            }
            if (min!=max && max - 1 + minBit <= 9) {
                int maxNum = Integer.parseInt(num.substring(max - 1, max - 1 + minBit));
                if (maxNum >= low && maxNum <= high) {
                    res.add(maxNum);
                }
            }

        } else {
            if (min - 1 + minBit <= 9) {
                int minNum = Integer.parseInt(num.substring(min - 1, min - 1 + minBit));
                if (minNum >= low) {
                    res.add(minNum);
                }
            }
            for (int i=min+1; i<9&&i-1+minBit<=9; i++) {
                res.add(Integer.parseInt(num.substring(i-1, i-1+minBit)));
            }

            for (int i = minBit+1; i<maxBit; i++) {
                for (int k=1; k<9&&k-1+i<=9; k++) {
                    res.add(Integer.parseInt(num.substring(k-1, k-1+i)));
                }
            }

            for (int i=1; i < max && i - 1 + maxBit <= 9; i++) {
                res.add(Integer.parseInt(num.substring(i - 1, i - 1 + maxBit)));
            }
            if (max - 1 + maxBit <= 9) {
                int maxNum = Integer.parseInt(num.substring(max - 1, max - 1 + maxBit));
                if (maxNum <= high) {
                    res.add(maxNum);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sequentialDigits(744,1298));
    }
}
