package solved.problem1to999._100to199._140to149.hasCycle141;


import java.util.*;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<Integer> hashCodes = new HashSet<>();
        while (head != null) {
            if (hashCodes.contains(head.hashCode())) {
                return true;
            }
            hashCodes.add(head.hashCode());
            head=head.next;
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(new ListNode(1)));
    }
}
