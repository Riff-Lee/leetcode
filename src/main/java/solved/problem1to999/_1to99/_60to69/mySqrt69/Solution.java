package solved.problem1to1000._1to100._61to70.mySqrt69;

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left<=right) {
            int mid = left + (right-left)/2;
            long pow =(long)mid *mid;
            if (pow == x) {
                return mid;
            }
            if (left==right) {
                return pow < x ? left : left-1;
            }
            if (pow < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
