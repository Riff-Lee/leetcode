package solved.problem1to999._100to199._130to139.solve130;

import java.util.*;

class Solution {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Node[] nodes = new Node[101];
    public Node cloneGraph(Node node) {
        if (node==null) {
            return null;
        }
        if (nodes[node.val]!=null) {
            return nodes[node.val];
        }
        Node cloneNode = new Node(node.val);
        nodes[node.val] = cloneNode;
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        System.out.println(solution.cloneGraph(node1));
    }
}
