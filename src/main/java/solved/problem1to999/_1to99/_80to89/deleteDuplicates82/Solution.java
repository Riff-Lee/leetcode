package solved.problem1to999._1to99._80to89.deleteDuplicates82;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int[] val = new int[201];
        while (head!=null) {
            val[head.val+100]++;
            head=head.next;
        }
        return create(val,0);
    }

    private ListNode create(int[] val, int i) {
        if (i>200) {
            return null;
        }
        if (val[i]!=1) {
            return create(val,i+1);
        }
        ListNode node = new ListNode(i-100);
        node.next = create(val,i+1);
        return node;
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
        System.out.println(solution.deleteDuplicates(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))))));
    }
}
