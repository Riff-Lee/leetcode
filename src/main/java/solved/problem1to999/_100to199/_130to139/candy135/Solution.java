package solved.problem1to1000._101to200._131to140.candy135;

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

//    int[] dp;
//
//    public int candy(int[] ratings) {
//        if (ratings.length == 1) {
//            return 1;
//        }
//        dp = new int[ratings.length];
//        int total = 0;
//        for (int i = 0; i < ratings.length; i++) {
//            total += help(ratings, i);
//        }
//        return total;
//    }
//
//    private int help(int[] ratings, int i) {
//        if (i < 0 || i >= ratings.length) {
//            return 0;
//        }
//        if (dp[i] != 0) {
//            return dp[i];
//        }
//        if (i == 0) {
//            if (ratings[1] >= ratings[0]) {
//                dp[0] = 1;
//                return 1;
//            }
//            return help(ratings, 1) + 1;
//        }
//        if (i == ratings.length - 1) {
//            if (ratings[i-1] >= ratings[i]) {
//                dp[i] = 1;
//                return 1;
//            }
//            return help(ratings, i-1) + 1;
//        }
//        if (ratings[i-1] >= ratings[i] && ratings[i+1] >= ratings[i]) {
//            dp[i] = 1;
//            return 1;
//        }
//        if (ratings[i-1] >= ratings[i]) {
//            return help(ratings, i+1) + 1;
//        }
//        if (ratings[i+1] >= ratings[i]) {
//            return help(ratings, i-1) + 1;
//        }
//        return Math.max(help(ratings, i+1), help(ratings, i-1)) + 1;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[] {0}));
    }
}
