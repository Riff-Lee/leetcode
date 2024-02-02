package solved.problem2001to3000._2801to2900.isReachableAtTime2849;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xDiff = Math.abs(sx-fx);
        int yDiff = Math.abs(sy-fy);
        if (xDiff==0 && yDiff==0) {
            return t==0 || t>=2;
        }
        return t >= Math.max(xDiff,yDiff);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isReachableAtTime(1,2,1,2,1));
    }
}
