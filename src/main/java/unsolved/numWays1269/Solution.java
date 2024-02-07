package unsolved.numWays1269;

class Solution {
    public int numWays(int steps, int arrLen) {
        if (steps==1||arrLen==1) {
            return 1;
        }
        if (steps/2+1 < arrLen) {
            return numWays(steps, steps/2+1);
        }

        int stopSteps = steps%2==0?0:1;
        int sum = 1;
        for (;stopSteps<steps;stopSteps=stopSteps+2) {
            sum += Math.pow(steps-stopSteps+1, stopSteps)*help(steps-stopSteps,arrLen);
        }
        return sum;
    }

    private int help(int steps, int arrLen) {
        if (steps/2+1 < arrLen) {
            return help(steps, steps/2+1);
        }
        if (steps==2) {
            return 1;
        }



        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(3,2));
    }
}
