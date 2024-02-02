package solved.problem1to1000._901to1000._931to40.knightDialer935;

class Solution {
    public int knightDialer(int n) {
        if (n==1) {
            return 10;
        }
        int mol = 1000000007;
        int[] lastStart = {1,1,1,1,1,0,1,1,1,1};
        for (int i = 1; i < n; i++) {
            lastStart = new int[]{
                    (lastStart[4]+lastStart[6])%mol,
                    (lastStart[6]+lastStart[8])%mol,
                    (lastStart[7]+lastStart[9])%mol,
                    (lastStart[4]+lastStart[8])%mol,
                    ((lastStart[0]+lastStart[3])%mol+lastStart[9])%mol,
                    0,
                    ((lastStart[0]+lastStart[1])%mol+lastStart[7])%mol,
                    (lastStart[2]+lastStart[6])%mol,
                    (lastStart[1]+lastStart[3])%mol,
                    (lastStart[2]+lastStart[4])%mol};
        }
        int sum = 0;
        for (int num : lastStart) {
            sum = (sum+num)%mol;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.knightDialer(3131));
    }
}
