package solved.problem1to999._1to99._20to29.strStr28;


public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("sadbutsad","sad"));
    }
}
