package solved.problem1to999._1to99._80to89.partition86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        int[] val = new int[201];
        int n=0;
        while (head!=null) {
            val[n++] = head.val;
            head = head.next;
        }
        return create(val,x,n,0, 0, false);
    }

    private ListNode create(int[] val, int x, int n, int i, int j, boolean flag) {
        if (i>=n) {
            return null;
        }
        if (j>=n) {
            if (flag) {
                return null;
            } else {
                return create(val,x,n,i,0,true);
            }
        }
        ListNode node = new ListNode();
        if (flag) {
            while (j<n&&val[j]<x) {
                j++;
            }
        } else {
            while (j<n&&val[j]>=x) {
                j++;
            }
        }
        if (j==n) {
            return create(val, x, n, i, 0, true);
        }
        node.val = val[j];
        node.next = create(val, x, n, i+1, j+1, flag);
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
        System.out.println(solution.partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2)))))),3));
    }
}
