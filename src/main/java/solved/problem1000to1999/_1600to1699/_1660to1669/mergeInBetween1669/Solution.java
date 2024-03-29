package solved.problem1000to1999._1600to1699._1660to1669.mergeInBetween1669;

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = list1;
        int i=0;
        while (i<a-1) {
            list1 = list1.next;
            i++;
        }
        ListNode sub = list1;
        while (i<b+1) {
            sub = sub.next;
            i++;
        }
        list1.next = list2;
        while (list1.next != null) {
            list1 = list1.next;
        }
        list1.next = sub;
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
        System.out.println(solution.mergeInBetween(new ListNode(10, new ListNode(1, new ListNode(13,new ListNode(6,new ListNode(9,new ListNode(5)))))), 3, 4, new ListNode(1000000,new ListNode(1000001,new ListNode(1000002)))));
    }
}
