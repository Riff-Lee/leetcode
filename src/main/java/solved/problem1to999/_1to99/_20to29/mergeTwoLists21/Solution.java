package solved.problem1to999._1to99._20to29.mergeTwoLists21;


import java.util.Stack;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) {
            return list2;
        }
        if (list2==null) {
            return list1;
        }
        if (list1.val<=list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
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
        System.out.println(solution.mergeTwoLists(new ListNode(1), new ListNode(2)));
    }
}
