package solved.problem1to999._200to299._230to239.isPowerOfTwo231;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) {
            return false;
        }
        while (n%2==0 || n==1) {
            if (n == 1) {
                return true;
            }
            n/=2;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var res= solution.isPowerOfTwo(16);
        System.out.println(res);
    }
}
