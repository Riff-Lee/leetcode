package solved.problem1to999._1to99._70to79.simplifyPath71;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");

        Deque<String> dq = new ArrayDeque<>();
        for (String name : names) {
            if ("".equals(name) || ".".equals(name)) {
                continue;
            }
            if ("..".equals(name)) {
                if (!dq.isEmpty()) {
                    dq.pollLast();
                }
                continue;
            }
            dq.offerLast(name);
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append("/").append(dq.pollFirst());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/../"));

    }
}
