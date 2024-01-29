package solved.problem2001to3000._2401to2500._2481to2490.onesMinusZeros2482;


public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        int[] zerosRow = new int[m];
        int[] zerosCol = new int[n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                } else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }
        int[][] diff = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.onesMinusZeros(new int[][] {{0}}));
    }
}
