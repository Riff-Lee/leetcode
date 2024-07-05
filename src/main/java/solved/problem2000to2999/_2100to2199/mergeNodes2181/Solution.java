package solved.problem2000to2999._2100to2199.mergeNodes2181;

import java.util.Arrays;

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = new ListNode();
        ListNode res = current;
        ListNode tail = null;
        int sum = 0;
        while (head.next!=null) {
            head = head.next;
            if (head.val == 0) {
                current.val = sum;
                current.next = new ListNode();
                tail = current;
                current = current.next;
                sum = 0;
            } else {
                sum += head.val;
            }
        }
        tail.next = null;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mergeNodes(new ListNode(0,new ListNode(3,new ListNode(1,new ListNode(0,new ListNode(4,new ListNode(5,new ListNode(2,new ListNode(0)))))))));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
