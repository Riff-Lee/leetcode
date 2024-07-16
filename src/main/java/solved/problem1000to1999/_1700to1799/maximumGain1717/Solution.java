package solved.problem1000to1999._1700to1799.maximumGain1717;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return getRes(s, x,y,'a','b');
        } else {
            return getRes(s, y,x,'b','a');
        }
    }

    private int getRes(String s, int x, int y, char a, char b) {
        Deque<Character> deque = new ArrayDeque<>();
        int res = 0;
        for (char ch: s.toCharArray()) {
            if (!deque.isEmpty() && deque.peek() == a && ch == b) {
                deque.pop();
                res+= x;
            } else {
                deque.push(ch);
            }
        }
        if (!deque.isEmpty()) {
            char[] remains = new char[deque.size()];
            int i=0;
            while (!deque.isEmpty()) {
                remains[i++] = deque.pollLast();
            }
            for (char ch: remains) {
                if (!deque.isEmpty() && deque.peek() == b && ch == a) {
                    deque.pop();
                    res+= y;
                } else {
                    deque.push(ch);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGain("cdbcbbaaabab",4,5));
    }
}
