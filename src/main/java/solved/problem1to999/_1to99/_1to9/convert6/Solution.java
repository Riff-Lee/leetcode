package solved.problem1to1000._1to100._1to10.addTwoNumbers2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return help(l1, l2, false);
    }

    private ListNode help(ListNode l1, ListNode l2, boolean carryFlag) {
        if (l1 ==null && l2==null) {
            return carryFlag ? new ListNode(1) : null;
        }
        ListNode res = new ListNode();
        if (l1 == null) {
            int nodeSum = carryFlag ? l2.val + 1 : l2.val;
            if (nodeSum < 10) {
                res.val = nodeSum;
                res.next = help(null, l2.next, false);
            } else {
                res.val = nodeSum-10;
                res.next = help(null, l2.next, true);
            }
            return res;
        }
        if (l2 == null) {

            int nodeSum = carryFlag ? l1.val + 1 : l1.val;
            if (nodeSum < 10) {
                res.val = nodeSum;
                res.next = help(l1.next, null, false);
            } else {
                res.val = nodeSum-10;
                res.next = help(l1.next, null, true);
            }
            return res;
        }

        int nodeSum = carryFlag ? l1.val + l2.val + 1 : l1.val + l2.val;
        if (nodeSum < 10) {
            res.val = nodeSum;
            res.next = help(l1.next, l2.next, false);
        } else {
            res.val = nodeSum-10;
            res.next = help(l1.next, l2.next, true);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(solution.addTwoNumbers(l1, l2));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */