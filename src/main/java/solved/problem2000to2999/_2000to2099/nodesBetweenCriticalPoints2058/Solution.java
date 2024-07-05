package solved.problem2000to2999._2000to2099.nodesBetweenCriticalPoints2058;

import java.util.Arrays;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minIndex = -1;
        int criNum = 0;
        int lastCriIndex = -1;
        int criType = 0;
        int index = 0;
        int minDis = -1;
        while (head.next!=null) {
            if (criType == -1) {
                if (head.next.val > head.val) {
                    criNum++;
                    minDis = lastCriIndex==-1 ? -1 : minDis == -1 ? index-lastCriIndex : Math.min(index-lastCriIndex, minDis);
                    lastCriIndex = index;
                    if (minIndex==-1) {
                        minIndex = index;
                    }
                }
            } else if (criType == 1) {
                if (head.next.val < head.val) {
                    criNum++;
                    minDis = lastCriIndex==-1 ? -1 : minDis == -1 ? index-lastCriIndex : Math.min(index-lastCriIndex, minDis);
                    lastCriIndex = index;
                    if (minIndex==-1) {
                        minIndex = index;
                    }
                }
            }
            if (head.val > head.next.val) {
                criType = -1;
            } else if (head.val < head.next.val) {
                criType = 1;
            } else {
                criType = 0;
            }
            index++;
            head = head.next;
        }

        if (criNum<2) {
            return new int[]{-1,-1};
        }
        return new int[] {minDis, lastCriIndex-minIndex};

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
        solution.nodesBetweenCriticalPoints(new ListNode());

    }
}
