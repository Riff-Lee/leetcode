package solved.problem1to999._1to99._50to59.spiralOrder54;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=-1;
        int right=matrix[0].length;
        int top=0;
        int bottom= matrix.length;
        int direction=0;//0->go right, 1->go down, 2->go left, 3->go up
        int i=0,j=0;
        int num=0;
        int total = right*bottom;
        List<Integer> res = new ArrayList<>();
        while (num<total) {
            switch (direction) {
                case 0:{
                    while (j<right) {
                        res.add(matrix[i][j++]);
                        num++;
                    }
                    i++;
                    j--;
                    right--;
                    direction=1;
                    break;
                }
                case 1:{
                    while (i<bottom) {
                        res.add(matrix[i++][j]);
                        num++;
                    }
                    i--;
                    j--;
                    bottom--;
                    direction=2;
                    break;
                }
                case 2:{
                    while (j>left) {
                        res.add(matrix[i][j--]);
                        num++;
                    }
                    i--;
                    j++;
                    left++;
                    direction=3;
                    break;
                }
                case 3:{
                    while (i>top) {
                        res.add(matrix[i--][j]);
                        num++;
                    }
                    i++;
                    j++;
                    top++;
                    direction=0;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
