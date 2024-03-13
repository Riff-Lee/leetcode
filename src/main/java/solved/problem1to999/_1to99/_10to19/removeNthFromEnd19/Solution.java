package solved.problem1to999._1to99._10to19.removeNthFromEnd19;


public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int[] val = new int[30];
        int i=0;
        while (head!=null) {
            val[i++]=head.val;
            head=head.next;
        }
        n=i-n;
        return create(val,n,i,0);

    }

    private ListNode create(int[] val, int n, int total, int i) {
        if (i>=total-1) {
            return null;
        }
        ListNode res = new ListNode();
        if (i<n) {
            res.val = val[i];
        } else {
            res.val = val[i+1];
        }
        res.next = create(val,n,total,i+1);
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
        System.out.println(solution.removeNthFromEnd(new ListNode(1,new ListNode(2,new ListNode(3))), 3));
    }
}
