package solved.problem1to999._1to99._20to29.reverseKGroup25;


public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        int[] val = new int[5001];
        int i=0;
        while (head!=null) {
            val[i++]=head.val;
            head=head.next;
        }
        return create(0, val, k, i, i/k*k);
    }

    private ListNode create(int i, int[] val, int k, int total, int limit) {
        if (i>=total) {
            return null;
        }
        ListNode res = new ListNode();
        if (i >= limit) {
            res.val = val[i];
        } else {
            res.val = val[(i/k+i/k+1)*k-1-i];
        }
        res.next = create(i+1,val,k,total,limit);
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
        System.out.println(solution.reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))), 2));
    }
}
