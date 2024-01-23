package solved.fullBloomFlowers2251;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];


        int[] flowerBloomStart = Arrays.stream(flowers)
                .sorted(Comparator.comparingInt(x -> x[0]))
                .mapToInt(x -> x[0])
                .toArray();


        int[] flowerBloomEnd = Arrays.stream(flowers)
                .sorted(Comparator.comparingInt(x -> x[1]))
                .mapToInt(x -> x[1] + 1)
                .toArray();

        for (int i = 0; i < people.length; i++) {
            int a = binarySearch(flowerBloomStart, people[i]);
            int b = binarySearch(flowerBloomEnd, people[i]);
            ans[i] = a - b;
        }

        return ans;
    }

    private int binarySearch(int[] array, int date) {
        int low = 0;
        int high = array.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (array[mid] > date) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullBloomFlowers(new int[][] {{1,10}, {3,3}}, new int[] {3,3,2}));
    }
}
