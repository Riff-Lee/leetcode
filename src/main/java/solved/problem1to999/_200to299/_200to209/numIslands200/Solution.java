package solved.problem1to999._200to299._200to209.numIslands200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        Map<Integer, List<String>> islandToLand = new HashMap<>();
        Map<String, Integer> landToIsland = new HashMap<>();
        if (grid[0][0]=='1') {
            num++;
            put(num, "0:0", islandToLand, landToIsland);
        }
        for (int j=1;j<grid[0].length;j++) {
            if (grid[0][j]=='0') {
                continue;
            }
            if (grid[0][j-1]=='0') {
                num++;
                put(num, "0:"+j, islandToLand, landToIsland);
            } else {
                int island = landToIsland.get("0:"+(j-1));
                put(island, "0:"+j, islandToLand, landToIsland);
            }
        }
        for (int i=1;i<grid.length;i++) {
            if (grid[i][0]=='0') {
                continue;
            }
            if (grid[i-1][0]=='0') {
                num++;
                put(num, i+":0", islandToLand, landToIsland);
            } else {
                int island = landToIsland.get((i-1)+":0");
                put(island, i+":0", islandToLand, landToIsland);
            }
        }

        for (int i=1;i<grid.length;i++) {
            for (int j=1;j<grid[0].length;j++) {
                if (grid[i][j]=='0') {
                    continue;
                }
                if (grid[i-1][j]=='0' && grid[i][j-1]=='0') {
                    num++;
                    put(num, i+":"+j, islandToLand, landToIsland);
                    continue;
                }
                if (grid[i-1][j]=='0') {
                    int island = landToIsland.get(i+":"+(j-1));
                    put(island, i+":"+j, islandToLand, landToIsland);
                    continue;
                }
                if (grid[i][j-1]=='0') {
                    int island = landToIsland.get((i-1)+":"+j);
                    put(island, i+":"+j, islandToLand, landToIsland);
                    continue;
                }
                int island1 = landToIsland.get((i-1)+":"+j);
                int island2 = landToIsland.get(i+":"+(j-1));
                if (island1!=island2) {
                    merge(island1, island2, islandToLand, landToIsland);
                }
                put(island1, i+":"+j, islandToLand, landToIsland);
            }
        }
        return islandToLand.size();
    }

    private void merge(int island1, int island2, Map<Integer, List<String>> islandToLand, Map<String, Integer> landToIsland) {
        List<String> island2List = islandToLand.get(island2);
        islandToLand.get(island1).addAll(island2List);
        islandToLand.remove(island2);
        island2List.forEach(k-> landToIsland.put(k, island1));
    }

    private void put(Integer island, String land, Map<Integer, List<String>> islandToLand, Map<String, Integer> landToIsland) {

        if (islandToLand.containsKey(island)) {
            islandToLand.get(island).add(land);
        } else {
            List<String> lands = new ArrayList<>();
            lands.add(land);
            islandToLand.put(island, lands);
        }
        landToIsland.put(land, island);
    }

    char[][] g;
    int m;
    int n;
    int count;
    public int numIslands1(char[][] grid) {
        //bfs through the grid
        g = grid;
        m = grid.length;
        n = grid[0].length;
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    count++;
                    mark(i, j);
                }
            }
        }
        return count;
    }

    private void mark(int i, int j) {
        g[i][j] = '2';
        if (i > 0 && g[i-1][j] =='1') {
            mark(i-1, j);
        }
        if (i < g.length-1 && g[i+1][j] == '1') {
            mark(i+1, j);
        }
        if (j > 0 && g[i][j-1] == '1') {
            mark(i, j-1);
        }
        if (j < g[0].length-1 && g[i][j+1] == '1') {
            mark(i, j+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numIslands(new char[][] {{'1','1','1','1','1','0','1','1','1','1'},{'1','0','1','0','1','1','1','1','1','1'},{'0','1','1','1','0','1','1','1','1','1'},{'1','1','0','1','1','0','0','0','0','1'},{'1','0','1','0','1','0','0','1','0','1'},{'1','0','0','1','1','1','0','1','0','0'},{'0','0','1','0','0','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','1'},{'1','1','1','1','1','1','1','1','0','1'},{'1','0','1','1','1','1','1','1','1','0'}}));
    }
}
