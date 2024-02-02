package solved.problem1to1000._901to1000.sumSubarrayMins907;


import java.util.Stack;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> st = new Stack<>();
        long sumOfMinimums = 0;

        for (int i = 0; i <= arr.length; i++) {
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int leftBoundary = st.empty() ? -1 : st.peek();
                int rightBoundary = i;

                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            st.push(i);
        }

        return (int) sumOfMinimums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumSubarrayMins(new int[] {3,1,2,4}));
    }

}
