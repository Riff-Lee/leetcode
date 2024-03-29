package solved.problem1to999._200to299._230to239.lowestCommonAncestor236;


import java.util.*;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }
        else{
            return root;
        }

    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Deque<Integer> pQueue = new ArrayDeque<>();
    Deque<Integer> qQueue = new ArrayDeque<>();
    boolean pFlag = true;
    boolean qFlag = true;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int key = root.val;
        help(root, p.val, q.val);
        while (!pQueue.isEmpty() && !qQueue.isEmpty() && pQueue.peek().equals(qQueue.peek())) {
            key=pQueue.poll();
            qQueue.poll();
        }
        return map.get(key);
    }

    private void help(TreeNode node, int p, int q) {
        if (node==null) {
            return;
        }
        if (!pFlag && !qFlag) {
            return;
        }
        map.put(node.val, node);
        if (pFlag) {
            pQueue.add(node.val);
            if (p==node.val) {
                pFlag =false;
            }
        }
        if (qFlag) {
            qQueue.add(node.val);
            if (q==node.val) {
                qFlag =false;
            }
        }
        help(node.left, p, q);
        help(node.right, p, q);
        if (pFlag) {
            pQueue.pollLast();
        }
        if (qFlag) {
            qQueue.pollLast();
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lowestCommonAncestor(new TreeNode(3,new TreeNode(5,new TreeNode(6),
                new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1)), new TreeNode(5), new TreeNode(4));
    }
}
