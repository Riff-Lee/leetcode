package solved.amountOfTime2385;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.TreeNode treeNode = new Solution.TreeNode(5,
                new Solution.TreeNode(4),
                new Solution.TreeNode(3));
        System.out.println(solution.amountOfTime(treeNode, 5));
    }

}
