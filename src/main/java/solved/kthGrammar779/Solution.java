package solved.kthGrammar779;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        if (kthGrammar(n-1, (k+1)/2) == 1) {
            return k%2 == 0 ? 0 : 1;
        } else {
            return k%2 == 0 ? 1 : 0;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthGrammar(2,1));
    }
}
