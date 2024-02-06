package solved.problem1to1000._201to300._221to230.calculate227;

import java.util.*;

class Solution {

    public int calculate(String s) {
        s=s.replace(" ", "");
        char[] chars = s.toCharArray();
        String left = "";
        int n = chars.length;
        Deque<String> nums = new ArrayDeque<>();

        for (int i=0;i<n;i++) {
            if (Character.isDigit(chars[i])) {
                left=left+chars[i];
                continue;
            }
            if (chars[i]=='+'||chars[i]=='-') {
                left="";
                continue;
            }
            String right = "";
            int j = 1;
            while (i+j<n&&Character.isDigit(chars[i+j])) {
                right = right+chars[i+j];
                j++;
            }
            int mid = chars[i] == '*' ? Integer.parseInt(left) * Integer.parseInt(right) : Integer.parseInt(left) / Integer.parseInt(right);

            s=s.substring(0,i-left.length())+"A".repeat(j+left.length())+s.substring(i+j,n);
            chars=s.toCharArray();
            if (i-left.length()-1>=0&&chars[i-left.length()-1]=='A') {
                nums.pollLast();
            }
            left=String.valueOf(mid);

            nums.offerLast(left);
            i=i+j-1;
        }
        left = "";
        char[] charsA = s.toCharArray();
        for (int i=0;i<n;i++) {
            if (charsA[i]=='A') {
                left=nums.pollFirst();
            }
            while (i<n&&charsA[i]=='A') {
                i++;
            }
            if (i==n) {
                break;
            }

            if (Character.isDigit(charsA[i])) {
                left=left+charsA[i];
                continue;
            }
            String right = "";
            int j = 1;
            while (i+j<n&&(Character.isDigit(charsA[i+j])||charsA[i+j]=='A')) {
                right = right+charsA[i+j];
                j++;
            }
            if (right.startsWith("A")) {
                right = nums.poll();
            }
            int mid = charsA[i] == '+' ? Integer.parseInt(left) + Integer.parseInt(right) : Integer.parseInt(left) - Integer.parseInt(right);
            left=String.valueOf(mid);
            i=i+j-1;
        }
        return Integer.parseInt(left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1+2*5/3+6/4*2"));
    }
}



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */