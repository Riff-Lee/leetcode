package solved.findSpecialInteger1287;

class Solution {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int limit = arr.length / 4;
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            count = last == arr[i] ? count+1 : 1;
            last = arr[i];
            if (count > limit) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
    }
}
