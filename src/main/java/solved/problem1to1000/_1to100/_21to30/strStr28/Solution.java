package solved.problem1to1000._1to100._21to30.strStr28;


public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("sadbutsad","sad"));
    }
}
