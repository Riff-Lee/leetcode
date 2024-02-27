package solved.problem1to999._1to99._50to59.lengthOfLastWord58;

class Solution {

    public int lengthOfLastWord(String s) {
        s=s.trim();
        int lastSpaceIndex=s.lastIndexOf(' ');
        return lastSpaceIndex==-1?s.length():s.length()-lastSpaceIndex-1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello"));
    }
}
