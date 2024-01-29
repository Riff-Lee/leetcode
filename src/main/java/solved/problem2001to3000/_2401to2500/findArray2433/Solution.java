package solved.problem2001to3000._2401to2500.findArray2433;

class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i] ^ pref[i-1];
        }
        return arr;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findArray(new int[] {5,2,0,3,1}));
    }
}
