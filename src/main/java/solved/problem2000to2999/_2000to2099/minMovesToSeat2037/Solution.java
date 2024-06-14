package solved.problem2000to2999._2000to2099.minMovesToSeat2037;

import java.util.Arrays;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i=0;i<seats.length;i++) {
            res+=Math.abs(seats[i]-students[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minMovesToSeat(new int[] {3,1,5}, new int[] {2,7,4});

    }
}
