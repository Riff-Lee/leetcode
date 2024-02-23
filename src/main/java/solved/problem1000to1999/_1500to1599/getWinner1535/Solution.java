package solved.problem1001to2000._1501to1600.getWinner1535;

import java.util.*;

class Solution {
    public int getWinner(int[] arr, int aim) {
        int maxIndex = 0;
        int lessAfter = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                lessAfter = 1;
                maxIndex = i;
            } else {
                lessAfter++;
            }
            if (lessAfter == aim) {
                break;
            }
        }
        return arr[maxIndex];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getWinner(new int[] {2,1,3,5,4,6,7},2));
    }
}
