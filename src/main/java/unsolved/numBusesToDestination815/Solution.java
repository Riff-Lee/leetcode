package unsolved.numBusesToDestination815;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int[][] nets = new int[1000001][1000001];

        int[] stationMap = new int[1000001];
        for (int[] route : routes) {
            for (int station : route) {

            }
        }

        int[] combineRoutes = nets[source];
        for (int route : combineRoutes) {

        }
        return 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numBusesToDestination(new int[][] {{1,2,7}, {3,6,7}}, 1, 6));
    }
}
