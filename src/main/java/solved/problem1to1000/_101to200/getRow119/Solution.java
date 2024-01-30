package solved.problem1to1000._101to200.getRow119;


import java.util.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> lastRow = getRow(rowIndex-1);
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i < lastRow.size(); i++) {
            res.add(lastRow.get(i) + lastRow.get(i-1));
        }
        res.add(1);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(33));
    }
}
