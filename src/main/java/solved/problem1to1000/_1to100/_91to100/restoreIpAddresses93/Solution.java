package solved.problem1to1000._1to100._91to100.restoreIpAddresses93;

import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        StringBuffer ip = new StringBuffer();
        for(int a=1; a<=3; a++){
            for(int b=1; b<=3; b++){
                for(int c=1; c<=3; c++){
                    int d = s.length()-(a+b+c);
                    if (d>=1 && d<=3) {
                        int A = Integer.parseInt(s.substring(0, a));
                        int B = Integer.parseInt(s.substring(a, a+b));
                        int C = Integer.parseInt(s.substring(a+b, a+b+c));
                        int D = Integer.parseInt(s.substring(a+b+c, a+b+c+d));
                        if(A<=255 && B<=255 && C<=255 && D<=255){
                            ip.append(A).append(".").append(B).append(".")
                                    .append(C).append(".").append(D);
                            if (ip.length() == s.length() + 3) {
                                result.add(ip.toString());
                            }
                            ip = new StringBuffer();
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

}
