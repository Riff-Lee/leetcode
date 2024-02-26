package solved.problem1to999._200to299.hIndex274;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 1;
        for (int i = citations.length-1; i>=0; i--) {
            if (citations[i] < hIndex) {
                break;
            }
            hIndex++;
        }
        return hIndex-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hIndex(new int[] {0,0,2}));
    }
}
