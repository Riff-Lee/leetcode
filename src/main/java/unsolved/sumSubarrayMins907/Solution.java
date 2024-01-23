package unsolved.sumSubarrayMins907;


public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int res = 0;
        int last;
        for (int i = 0; i < n; i++) {
            last = arr[i];
            res = (res+last) % 1000000007;
            for (int j = i+1; j < n; j++) {
                last = Math.min(last, arr[j]);
                res = (res+last) % 1000000007;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumSubarrayMins(new int[] {3,1,2,4}));
    }

}
