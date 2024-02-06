package unsolved.decodeAtIndex880;

class Solution {
    public String decodeAtIndex(String s, int k) {
        StringBuilder decode = new StringBuilder();
        int length = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                decode.append(decode.toString().repeat(Character.getNumericValue(ch)-1));
            } else {
                decode.append(ch);
                length++;
            }
            if (length>=k) {
                break;
            }
        }
        return decode.substring(k-1,k);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeAtIndex("leet2code3",10));
    }
}
