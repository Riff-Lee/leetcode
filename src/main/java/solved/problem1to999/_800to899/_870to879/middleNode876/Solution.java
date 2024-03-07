package solved.problem1to999._800to899._870to879.middleNode876;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode middleNode(ListNode head) {
        int length=0;
        ListNode origin = head;
        while (head!=null) {
            length++;
            head = head.next;
        }
        int mid = length>>1;
        while (mid>0) {
            mid--;
            origin = origin.next;
        }
        return origin;
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
        System.out.println(solution.middleNode(new ListNode(1, new ListNode(2, new ListNode(2)))));
    }
}
