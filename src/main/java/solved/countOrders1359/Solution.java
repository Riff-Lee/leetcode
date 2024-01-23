package solved.countOrders1359;

class Solution {



    public int countOrders(int n) {
        long[] counts = new long[n+1];
        counts[1] = 1;
        int mol = 1000000007;
        for (int i = 2; i <= n; i++) {
            int current = i * (2 * i -1);
            counts[i] = current * counts[i-1] % mol;
        }
        return (int)counts[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOrders(3));
    }
}
