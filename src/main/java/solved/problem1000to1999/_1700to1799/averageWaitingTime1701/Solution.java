package solved.problem1000to1999._1700to1799.averageWaitingTime1701;

class Solution {
    public double averageWaitingTime(int[][] customers) {
        long sum = 0;
        long lastWait = 0;
        int lastArrival = 0;
        for (int[] customer : customers) {
            lastWait = customer[1] + Math.max(0, lastWait - customer[0] + lastArrival);
            sum += lastWait;
            lastArrival = customer[0];
        }
        return (double) sum/customers.length;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageWaitingTime(new int[][] {{1,2},{2,5},{4,3}}));
    }
}
