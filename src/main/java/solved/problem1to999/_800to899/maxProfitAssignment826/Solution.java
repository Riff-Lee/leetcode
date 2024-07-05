package solved.problem1to999._800to899.maxProfitAssignment826;


import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int maxDifficulty = 0;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w: worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }

    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) {
        Pro[] pros = new Pro[difficulty.length];
        for (int i=0;i<difficulty.length;i++) {
            pros[i] = new Pro(difficulty[i], profit[i]);
        }
        Arrays.sort(pros, Comparator.comparingInt(o -> o.difficulty));
        Arrays.sort(worker);
        int res = 0;
        int j=0;
        int max = 0;
        for (int i=0;i<worker.length;i++) {
            while (j<pros.length&&worker[i]>=pros[j].difficulty) {
                max=Math.max(max, pros[j].profit);
                j++;
            }
            res+=max;
        }
        return res;
    }
    static class Pro {
        Integer difficulty;
        Integer profit;
        public Pro(Integer difficulty, Integer profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfitAssignment(new int[] {85,47,57}, new int[]{24,66,99}, new int[]{40,25,25}));
    }
}
