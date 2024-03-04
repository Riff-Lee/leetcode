package solved.problem1to999._1to99._40to49.rotate48;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] origin = new int[n][n];
        for (int i=0;i<n;i++) {
            System.arraycopy(matrix[i], 0, origin[i], 0, n);
        }
        for (int i=0;i<n;i++) {
            int col = n-i-1;
            for (int j=0;j<n;j++) {
                matrix[j][col] = origin[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
}
