package solved.problem1to999._100to199._100to109.buildTree105;


public class Solution {
    int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        int n = inorder.length;
        return create(0, n, 0, n);
    }

    private TreeNode create(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart==preEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = preorder[preStart];
        if (preorder[preStart]==inorder[inStart]) {
            treeNode.right = create(preStart+1,preEnd,inStart+1,inEnd);
        } else {
            int mid=inStart+1;
            for (;mid<inEnd;mid++) {
                if (inorder[mid]==preorder[preStart]) {
                    break;
                }
            }
            treeNode.left = create(preStart+1, preStart+1+mid-inStart, inStart, mid);
            treeNode.right = create(preStart+1+mid-inStart, preEnd, mid+1, inEnd);
        }
        return treeNode;
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
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
}
