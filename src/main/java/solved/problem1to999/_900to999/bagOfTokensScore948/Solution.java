package solved.problem1to999._900to999.bagOfTokensScore948;


import java.util.*;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        if (tokens.length==0||power<tokens[0]) {
            return 0;
        }
        int score = 0;
        int left = 0;
        int right = tokens.length-1;
        while (left<=right) {
            if (tokens[left]<=power) {
                power-=tokens[left++];
                score++;
            } else {
                if (left<right) {
                    power+=tokens[right--];
                    score--;
                } else {
                    break;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bagOfTokensScore(new int[] {100},50));
    }

}
