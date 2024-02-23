package solved.problem1to1000._1to100._81to90.grayCode89;

import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<(1<<n); i++) {
            ans.add(i ^ (i>>1));
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(4));
    }
}
