package solved.problem1to999._200to299._230to239.deleteNode237;

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        if (node.next.next == null) {
            node.next = null;
        } else {
            node.next = node.next.next;
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
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        solution.deleteNode(head.next);
    }
}
