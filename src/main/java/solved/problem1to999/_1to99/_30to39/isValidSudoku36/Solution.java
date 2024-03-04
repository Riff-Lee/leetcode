package solved.problem1to999._1to99._30to39.isValidSudoku36;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && checkSubCell(board);
    }

    private boolean checkSubCell(char[][] board) {
        for (int i=0;i<3;i++) {
            int row = 3*i;
            for (int j=0;j<3;j++) {
                int col=3*j;
                boolean[] flag = new boolean[10];
                for (int r=row;r<row+3;r++) {
                    for (int c = col; c <col+3; c++) {
                        if (board[r][c] == '.') {
                            continue;
                        }
                        if (flag[board[r][c]-'0']) {
                            return false;
                        }
                        flag[board[r][c]-'0'] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkCol(char[][] board) {
        for (int i=0;i<9;i++) {
            boolean[] flag = new boolean[10];
            for (int j=0;j<9;j++) {
                if (board[j][i]=='.') {
                    continue;
                }
                if (flag[board[j][i]-'0']) {
                    return false;
                }
                flag[board[j][i]-'0']=true;
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board) {
        for (int i=0;i<9;i++) {
            boolean[] flag = new boolean[10];
            for (int j=0;j<9;j++) {
                if (board[i][j]=='.') {
                    continue;
                }
                if (flag[board[i][j]-'0']) {
                    return false;
                }
                flag[board[i][j]-'0']=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}}));
    }
}
