package solved.problem1001to2000._1501to1600.minCostConnectPoints1584;

import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> distances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int[] dist = new int[3];
                dist[0] = i;
                dist[1] = j;
                dist[2] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                distances.add(dist);
            }
        }
        distances.sort(Comparator.comparingInt(d -> d[2]));
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int cost = 0;
        int edgeCount = 0;

        for (int[] edge : distances) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (union(parent, u, v)) {
                cost += weight;
                edgeCount++;
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        return cost;
    }

    private boolean union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            return true;
        }

        return false;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return find(parent, parent[x]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][] {{3,12}, {-2,5}, {-4,1}}));
    }
}
