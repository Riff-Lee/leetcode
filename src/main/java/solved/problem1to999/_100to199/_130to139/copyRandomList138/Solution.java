package solved.problem1to999._100to199._130to139.copyRandomList138;

import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Integer, Integer> map = new HashMap<>();
        Node current = head;
        int i=0;
        while (current!=null) {
            map.put(current.hashCode(), i++);
            current = current.next;
        }
        Node[] arr = new Node[1001];
        int[] random = new int[1001];
        Node node = copyNode(head, arr, 0, map, random);
        addRandom(node,0,arr,random);

        return node;
    }

    private void addRandom(Node node, int depth, Node[] arr, int[] random) {
        if (node==null) {
            return;
        }
        node.random = random[depth]>=0? arr[random[depth]] : null;
        addRandom(node.next, depth+1,arr,random);
    }

    private Node copyNode(Node node, Node[] arr, int depth, Map<Integer, Integer> map, int[] random) {
        if (node==null) {
            return null;
        }
        Node res = new Node(node.val);
        res.next = copyNode(node.next,arr,depth+1,map,random);
        arr[depth] = res;
        random[depth] = node.random == null ? -1 : map.get(node.random.hashCode());
        return res;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next=node1;
        node1.next=node2;
        node1.random=head;
        node2.next=node3;
        node2.random=node4;
        node3.next=node4;
        node3.random=node2;
        node4.random=head;

        System.out.println(solution.copyRandomList(null));
    }
}
