package solved.problem1to999._100to199._120to129.isPalindrome125;



class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]", "");
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left<right) {
            if (chars[left]!=chars[right]) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(""));
    }
}
