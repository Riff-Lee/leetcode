package solved.problem2000to2999._2400to2499._2480to2489.appendCharacters2486;


public class Solution {
    public int appendCharacters(String s, String t) {
        char[] tChars = t.toCharArray();
        int remain = tChars.length;
        int cur = 0;
        for (char ch : s.toCharArray()) {
            if (remain == 0) {
                break;
            }
            if (tChars[cur] == ch) {
                cur++;
                remain--;
            }
        }
        return remain;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.appendCharacters("coaching", "coding"));
    }
}
