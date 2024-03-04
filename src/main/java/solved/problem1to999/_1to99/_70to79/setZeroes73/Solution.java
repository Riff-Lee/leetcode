package solved.problem1to999._1to99._70to79.setZeroes73;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] origin = new int[m][n];
        for (int i=0;i<m;i++) {
            System.arraycopy(matrix[i], 0, origin[i], 0, n);
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (origin[i][j]==0) {
                    for (int k=0;k<m;k++) {
                        matrix[k][j]=0;
                    }
                    for (int v=0;v<n;v++) {
                        matrix[i][v]=0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.setZeroes(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
}
