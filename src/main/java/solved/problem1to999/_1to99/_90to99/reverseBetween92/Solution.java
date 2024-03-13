package solved.problem1to999._1to99._90to99.reverseBetween92;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right||head==null||head.next==null) {
            return head;
        }
        int[] val = new int[501];
        int i=1;
        while (head!=null) {
            val[i++]=head.val;
            head=head.next;
        }
        return createNode(val, left, right, 1, i);

    }

    private ListNode createNode(int[] val, int left, int right, int depth, int total) {
        if (depth==total) {
            return null;
        }
        ListNode res = new ListNode();
        if (depth>=left && depth<=right) {
            res.val = val[left+right-depth];
        } else {
            res.val = val[depth];
        }

        res.next = createNode(val, left, right, depth+1,total);
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
        System.out.println(solution.reverseBetween(new ListNode(1,new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5))))),2,4));
    }

}
