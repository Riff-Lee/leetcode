package solved.problem1to999._100to199._100to109.buildTree106;


public class Solution {
    int[] postorder,inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder=postorder;
        this.inorder=inorder;
        int n = inorder.length;
        return create(-1, n-1, -1, n-1);
    }

    private TreeNode create(int postStart, int postEnd, int inStart, int inEnd) {
        if (postStart==postEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = postorder[postEnd];
        if (postorder[postEnd]==inorder[inEnd]) {
            treeNode.left = create(postStart,postEnd-1,inStart,inEnd-1);
        } else {
            int mid=inEnd-1;
            for (;mid>inStart;mid--) {
                if (inorder[mid]==postorder[postEnd]) {
                    break;
                }
            }
            int length = mid-inStart-1;
            treeNode.left = create(postStart, postStart+length, inStart, mid-1);
            treeNode.right = create(postStart+length, postEnd-1, mid, inEnd);
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
