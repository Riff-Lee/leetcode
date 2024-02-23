package solved.problem1001to2000._1801to1900.makeEqual1897;

class Solution {
    public boolean makeEqual(String[] words) {
        int[] letterNum = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                letterNum[ch-97]++;
            }
        }
        int n = words.length;
        for (int num : letterNum) {
            if (num%n!=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeEqual(new String[] {"abc","aabc","bc"}));
    }
}
