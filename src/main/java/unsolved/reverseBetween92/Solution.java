package unsolved.reverseBetween92;

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
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] dp = new int[right-left+1];
        ListNode current = head;
        int count = 1;
        int dpIndex = 0;
        while (current!=null) {
            if (count>=left && count<=right) {
                dp[dpIndex++] = current.val;
            }
            current = current.next;
            count++;
        }
        ListNode res = head;
        ListNode cur = null;


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
        System.out.println(solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),2,4));
    }
}
