package solved.problem1to999._200to299._200to209.reverseList206;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next == null) {
            return head;
        }
        int[] list = new int[5000];
        int total = 0;
        while (head!=null) {
            list[total] = head.val;
            total++;
            head = head.next;
        }
        total--;
        ListNode res = new ListNode(list[total--]);
        ListNode current = res;
        for (;total>=0;total--) {
            current.next = new ListNode(list[total]);
            current = current.next;
        }
        return res;
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
        System.out.println(solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
