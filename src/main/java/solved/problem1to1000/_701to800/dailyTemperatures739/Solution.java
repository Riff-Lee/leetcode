package solved.problem1to1000._701to800.dailyTemperatures739;

import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<>();

        for (int i=0;i<temperatures.length;i++) {
            if (indexStack.empty() || temperatures[indexStack.peek()] >= temperatures[i]) {
                indexStack.add(i);
                continue;
            }
            while (!indexStack.empty() && temperatures[indexStack.peek()] < temperatures[i]) {
                temperatures[indexStack.peek()] = i-indexStack.pop();
            }
            indexStack.add(i);
        }
        while (!indexStack.empty()) {
            temperatures[indexStack.pop()] = 0;
        }
        return temperatures;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dailyTemperatures(new int[] {733}));
    }
}
