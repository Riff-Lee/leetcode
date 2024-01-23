package solved.countBits338;

import java.util.Arrays;

class Solution {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 1; i <= num; i++){
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public int[] countBits1(int n) {
        int[] res = new int[n+1];
        String binary = "0";
        int ones = 0;
        for (int i=0; i<=n; i++) {
            res[i] = ones;
            int lastZero = binary.lastIndexOf('0');
            int length = binary.length();
            if (lastZero < 0) {
                ones = 1;
                binary = "1" + "0".repeat(length);
            } else {
                ones = ones - (length - lastZero) + 2;
                binary = binary.substring(0, lastZero) + "1" + "0".repeat(length - lastZero - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBits(5));
    }
}
