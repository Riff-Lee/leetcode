package solved.problem1000to1999._1100to1199.reverseParentheses1190;

import java.util.*;

class Solution {

    public String reverseParentheses(String s) {
        Deque<Deque<Character>> stacks = new ArrayDeque<>();
        Deque<Character> current = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stacks.push(current);
                current = new ArrayDeque<>();
            } else if (ch == ')') {
                Deque<Character> lastStack = stacks.pop();
                while (!current.isEmpty()) {
                    lastStack.push(current.pop());
                }
                current = lastStack;
            } else {
                current.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!current.isEmpty()) {
            sb.append(current.pollLast());
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.asList(solution.reverseParentheses("(abcd)")));
    }
}
