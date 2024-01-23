package solved.rangesumofBTS938;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.TreeNode treeNode = new Solution.TreeNode(10, new Solution.TreeNode(5, new Solution.TreeNode(3), new Solution.TreeNode(7)), new Solution.TreeNode(15, null, new Solution.TreeNode(18)));
        System.out.println(solution.rangeSumBST(treeNode,7,15));
    }

}
