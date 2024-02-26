package solved.problem1to999._300to399._380to389.canConstruct383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (char ch:magazine.toCharArray()) {
            letters[ch-'a']++;
        }
        for (char ch:ransomNote.toCharArray()) {
            letters[ch-'a']--;
        }
        for (int num : letters) {
            if (num<0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
    }
}
