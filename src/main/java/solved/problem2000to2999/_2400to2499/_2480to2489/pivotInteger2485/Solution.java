package solved.problem2000to2999._2400to2499._2480to2489.pivotInteger2485;


public class Solution {
    public int pivotInteger(int n) {
        int y = n*(n+1)/2;
        int x = (int) Math.sqrt(y);
        return x*x == y ? x : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotInteger(8));
    }
}
