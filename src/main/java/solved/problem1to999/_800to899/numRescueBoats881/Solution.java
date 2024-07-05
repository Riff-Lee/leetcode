package solved.problem1to999._800to899.numRescueBoats881;


import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (people[r] == limit) {
            res++;
            r--;
            n--;
        }
        while (l < r) {
            if (people[r]+people[l]<=limit) {
                l++;
                r--;
                n-=2;
            } else {
                r--;
                n--;
            }
            res++;
        }
        if (n!=0) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRescueBoats(new int[] {1,2}, 3));
    }
}
