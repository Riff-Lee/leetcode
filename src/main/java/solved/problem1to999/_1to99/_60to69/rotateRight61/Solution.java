package solved.problem1to999._1to99._60to69.rotateRight61;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int[] val = new int[501];
        int n=0;
        while (head!=null) {
            val[n++] = head.val;
            head=head.next;
        }
        if (n==0) {
            return null;
        }
        return create(val,n,n-k%n,0);
    }

    private ListNode create(int[] val, int n, int index, int i) {
        if (i>=n) {
            return null;
        }

        if (index>=n) {
            index = index-n;
        }
        ListNode res = new ListNode(val[index]);
        res.next = create(val,n,index+1,i+1);
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
        System.out.println(solution.rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5))))))),4));
    }
}
