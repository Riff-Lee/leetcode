package solved.combinations77;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        combine(n, k, 1, new ArrayList<>(), res);

        return res;
    }

    public void combine(int n, int k, int curIdx, List<Integer> cur, List<List<Integer>> res) {
        if(k==0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(k>n-curIdx+1) {
            return;
        }

        for(int i=curIdx;i<=n;i++){
            cur.add(i);
            combine(n, k - 1, i+1, cur, res);
            cur.remove(cur.size()-1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> [][] dp = new List[n+1][k+1];
        return cal(dp, n, k);
    }

    private List<List<Integer>> cal(List<List<Integer>> [][] dp, int i, int j) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == 0 || j == 0) {
            dp[i][j] = Arrays.asList(new ArrayList<>());
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = Arrays.asList(IntStream.rangeClosed(1, i).boxed().collect(Collectors.toList()));
            return dp[i][j];
        }
        if (j == 1) {
            List<List<Integer>> gene = new ArrayList<>();
            for (int m = 1; m <= i; m++) {
                List<Integer> singleList = new ArrayList<>();
                singleList.add(m);
                gene.add(singleList);
            }
            dp[i][j] = gene;
            return dp[i][j];
        }


        dp[i][j] = new ArrayList<>();
        dp[i][j].addAll(cal(dp, i-1, j));
        List<List<Integer>> temps = new ArrayList<>(cal(dp, i-1, j-1));
        for (List<Integer> temp : temps) {
            List<Integer> add = new ArrayList<>(temp);
            add.add(i);
            dp[i][j].add(add);
        }

        return dp[i][j];
    }


    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> [] dp = new List[n+1];

        dp[k] = Arrays.asList(IntStream.rangeClosed(1, k).boxed().collect(Collectors.toList()));
        for (int i = k+1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].addAll(dp[i-1]);
            Set<List<Integer>> exist = new HashSet<>();
            for (int m = 0; m < dp[i-1].toArray().length; m++) {
                for (int j = 0; j < k; j++) {
                    List<Integer> mArray = new ArrayList<>(dp[i-1].get(m));
                    mArray.remove(j);
                    mArray.add(i);
                    if (!exist.contains(mArray)) {
                        exist.add(mArray);
                        dp[i].add(mArray);
                    }
                }
            }

        }
        return dp[n];
    }

}
