package solved.imageSmoother661;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                res[i][j] = countAverage(img, i, j);
            }
        }
        return res;
    }

    private int countAverage(int[][] img, int i, int j) {
        if (img.length==1&&img[0].length==1) {
            return img[i][j];
        }
        if (img.length==1) {
            if (j==0){
                return (img[i][j]+ img[i][j+1])/2;
            }
            if (j==img[0].length-1){
                return (img[i][j-1] + img[i][j])/2;
            }
            return (img[i][j-1] +img[i][j] + img[i][j+1])/3;
        }
        if (img[0].length==1) {
            if (i==0){
                return (img[i][j]+ img[i+1][j])/2;
            }
            if (i==img.length-1){
                return (img[i-1][j] + img[i][j])/2;
            }
            return (img[i-1][j] +img[i][j] + img[i+1][j])/3;
        }

        if (i==0&&j==0){
            return (img[i][j] + img[i+1][j] + img[i][j+1] + img[i+1][j+1])/4;
        }
        if (i==img.length-1&&j==img[0].length-1){
            return (img[i-1][j-1] + img[i][j-1] + img[i-1][j] + img[i][j])/4;
        }
        if (i==0&&j==img[0].length-1){
            return (img[i][j-1] + img[i+1][j-1] + img[i][j] + img[i+1][j])/4;
        }
        if (i==img.length-1&&j==0){
            return (img[i-1][j] + img[i][j] + img[i-1][j+1] + img[i][j+1])/4;
        }
        if (i==0){
            return (img[i][j-1] + img[i+1][j-1] +img[i][j] + img[i+1][j] + img[i][j+1] + img[i+1][j+1])/6;
        }
        if (i==img.length-1){
            return (img[i-1][j-1] + img[i][j-1] + img[i-1][j] + img[i][j] + img[i-1][j+1] + img[i][j+1])/6;
        }
        if (j==0){
            return (img[i-1][j] + img[i][j] + img[i+1][j] + img[i-1][j+1] + img[i][j+1] + img[i+1][j+1])/6;
        }
        if (j==img[0].length-1){
            return (img[i-1][j-1] + img[i][j-1] + img[i+1][j-1] + img[i-1][j] + img[i][j] + img[i+1][j])/6;
        }

        return (img[i-1][j-1] + img[i][j-1] + img[i+1][j-1] + img[i-1][j] + img[i][j] + img[i+1][j] + img[i-1][j+1] + img[i][j+1] + img[i+1][j+1])/9;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.imageSmoother(new int[][] {{1}}));
    }
}
