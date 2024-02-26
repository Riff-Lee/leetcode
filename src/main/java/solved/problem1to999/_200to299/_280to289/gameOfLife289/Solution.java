package solved.problem1to999._200to299._280to289.gameOfLife289;

import java.util.Arrays;

class Solution {
    int m;
    int n;
    int[][] origin;
    public void gameOfLife(int[][] board) {
        m=board.length;
        n=board[0].length;
        origin = Arrays.stream(board)
                .map(int[]::clone)
                .toArray(int[][]::new);
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                board[i][j] = isLive(i,j);
            }
        }
    }
    private int isLive(int i, int j) {
        int live = get(i-1,j-1) + get(i-1,j) + get(i-1,j+1) + get(i,j-1) + get(i,j+1) + get(i+1,j-1) + get(i+1,j) + get(i+1,j+1);
        if (live<2 || live>3) {
            return 0;
        }
        if (live==3) {
            return 1;
        }
        return origin[i][j];
    }

    public int get(int i, int j) {
        if (i<0||j<0||i>=m||j>=n) {
            return 0;
        }
        return origin[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.gameOfLife(new int[][] {{0,1,0}, {0,0,1},{1,1,1},{0,0,0}});
    }
}
