package solved.problem1to999._1to99._40to49.permutations46;

import java.util.Arrays;

class Solution {
    public int numberOfBeams(String[] bank) {

        int n = bank[0].length();
        bank = Arrays.stream(bank)
                .filter(s -> !s.equals("0".repeat(n)))
                .toArray(String[]::new);
        int m = bank.length;
        if (m <= 1) {
            return 0;
        }

        int[] oneNum = new int[m];
        for (int i = 0; i < m; i++) {
            oneNum[i] = (int) bank[i].chars().filter(b -> b=='1').count();
        }

        int num = 0;
        for (int i = 0; i < m-1; i++) {
            num += oneNum[i] * oneNum[i+1];
        }
        return num;
    }
}
