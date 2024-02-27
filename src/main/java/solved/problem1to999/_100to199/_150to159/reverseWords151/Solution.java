package solved.problem1to999._100to199._150to159.reverseWords151;

class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s.replaceAll("\s+"," ");
        String[] words=s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=words.length-1;i>=0;i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
