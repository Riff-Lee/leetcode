package solved.problem1to999._1to99._10to19.romanToInt13;

class Solution {

    public int romanToInt(String s) {
        s=s.replace("IV", "1");
        s=s.replace("IX", "2");
        s=s.replace("XL", "3");
        s=s.replace("XC", "4");
        s=s.replace("CD", "5");
        s=s.replace("CM", "6");
        int sum = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'I' -> sum += 1;
                case 'V' -> sum += 5;
                case 'X' -> sum += 10;
                case 'L' -> sum += 50;
                case 'C' -> sum += 100;
                case 'D' -> sum += 500;
                case 'M' -> sum += 1000;
                case '1' -> sum += 4;
                case '2' -> sum += 9;
                case '3' -> sum += 40;
                case '4' -> sum += 90;
                case '5' -> sum += 400;
                case '6' -> sum += 900;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
    }
}
