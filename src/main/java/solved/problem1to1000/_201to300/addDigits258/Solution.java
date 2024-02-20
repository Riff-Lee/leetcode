package solved.problem1to1000._201to300.addDigits258;

class Solution {
    public int addDigits(int num) {
        while (num>9) {
            int sum = 0;
            do {
                int mol = num % 10;
                sum +=mol;
                num = num/10;
            } while (num>0);
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits(Integer.MAX_VALUE));
    }
}
