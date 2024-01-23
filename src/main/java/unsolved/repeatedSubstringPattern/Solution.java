package unsolved.repeatedSubstringPattern;
class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1) {
            return false;
        }
        int step = 1;
        String sub = s.substring(0, 1);
        int i = 1;
        boolean flag = true;
        while (i < n-step) {
            if (s.substring(i, i+step).equals(sub)) {
                i+=step;
                flag = true;
            } else {
                step++;
                i = flag ? i + step - 1 : i + 1;
                flag = false;
                sub = s.substring(0, step);
            }
        }
        return n == i + step && s.substring(i, i+step).equals(sub);
    }
}