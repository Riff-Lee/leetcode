package solved.problem1to999._600to699.judgeSquareSum633;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean judgeSquareSum(int c) {
        int sqr = (int) Math.pow(c, 0.5);
        int[] pow2 = new int[sqr+1];
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<=sqr; i++) {
            pow2[i] = i*i;
            set.add(pow2[i]);
        }
        for (int i=0; i<=sqr; i++) {
            if (set.contains(c-pow2[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        int b=(int)Math.ceil(Math.pow(c,0.5));
        int a=0;
        while(a<=b){
            int val=c-b*b;
            int aPow = a*a;
            if(val==aPow){
                return true;
            }else if(val<aPow){
                b--;
            }else{
                a++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(2147483643));
    }
}
