package solved.problem1to999._1to99._20to29.isValid20;


import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if (n%2!=0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch:chars) {
            if (stack.empty()) {
                if (ch==')'||ch==']'||ch=='}') {
                    return false;
                }
                stack.add(ch);
            } else {
                switch (ch) {
                    case '(', '{', '[' -> stack.add(ch);
                    case ')' -> {
                        if (stack.pop()!='(') {
                            return false;
                        }
                    }
                    case ']' -> {
                        if (stack.pop()!='[') {
                            return false;
                        }
                    }
                    case '}' -> {
                        if (stack.pop()!='{') {
                            return false;
                        }
                    }
                }

            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("("));
    }
}
