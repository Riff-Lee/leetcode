package solved.rmneighborssamecolor2038;

public class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        char[] c = colors.toCharArray();
        int a = 0;
        for (int i = 1; i < c.length - 1; i++) {
            if (c[i+1] == c[i] && c[i-1] == c[i]) {
                if (c[i] == 'A') {
                    a++;
                } else {
                    a--;
                }
            }
        }
        return a > 0;
    }

}
