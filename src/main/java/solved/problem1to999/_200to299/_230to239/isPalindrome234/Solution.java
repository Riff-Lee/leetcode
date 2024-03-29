package solved.problem1to999._200to299._230to239.isPalindrome234;


import java.util.*;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        while (!deque.isEmpty() && deque.size()!=1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }
        return true;
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
        solution.isPalindrome(new ListNode());
    }
}
