package solved.problem1to999._100to199._150to159.evalRPN150;


import java.util.*;

public class Solution {
    Set<String> opr = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        int i = 0;
        for (; i < tokens.length; i++) {
            if (opr.contains(tokens[i])) {
                break;
            }
        }
        int left = i-2;
        for (; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    int temp = Integer.parseInt(tokens[left]) + Integer.parseInt(tokens[i - 1]);
                    tokens[i] = String.valueOf(temp);
                    tokens[i-1] = "N";
                    tokens[left] = "N";
                    if (i < tokens.length - 1 && opr.contains(tokens[i+1])) {
                        left = getLeft(tokens, left-1);
                    } else {
                        left = i;
                    }
                }
                case "-" -> {
                    int temp = Integer.parseInt(tokens[left]) - Integer.parseInt(tokens[i - 1]);
                    tokens[i] = String.valueOf(temp);
                    tokens[i-1] = "N";
                    tokens[left] = "N";
                    if (i < tokens.length - 1 && opr.contains(tokens[i+1])) {
                        left = getLeft(tokens, left-1);
                    } else {
                        left = i;
                    }
                }
                case "*" -> {
                    int temp = Integer.parseInt(tokens[left]) * Integer.parseInt(tokens[i - 1]);
                    tokens[i] = String.valueOf(temp);
                    tokens[i-1] = "N";
                    tokens[left] = "N";
                    if (i < tokens.length - 1 && opr.contains(tokens[i+1])) {
                        left = getLeft(tokens, left-1);
                    } else {
                        left = i;
                    }
                }
                case "/" -> {
                    int temp = Integer.parseInt(tokens[left]) / Integer.parseInt(tokens[i - 1]);
                    tokens[i] = String.valueOf(temp);
                    tokens[i-1] = "N";
                    tokens[left] = "N";
                    if (i < tokens.length - 1 && opr.contains(tokens[i+1])) {
                        left = getLeft(tokens, left-1);
                    } else {
                        left = i;
                    }
                }
                default -> {
                    if (left == i-2) {
                        left++;
                    }
                }
            }
        }
        return Integer.parseInt(tokens[tokens.length-1]);
    }

    private int getLeft(String[] tokens, int left) {
        if (tokens[left].equals("N")) {
            return getLeft(tokens, left-1);
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[] {"4","-2","/","2","-3","-","-"}));
    }
}
