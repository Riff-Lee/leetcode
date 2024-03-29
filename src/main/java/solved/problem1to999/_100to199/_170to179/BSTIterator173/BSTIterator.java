package solved.problem1to999._100to199._170to179.BSTIterator173;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTIterator {
    Queue<Integer> queue = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        help(root);
    }

    private void help(TreeNode node) {
        if (node == null) {
            return;
        }
        help(node.left);
        queue.add(node.val);
        help(node.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    public class TreeNode {
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
}
