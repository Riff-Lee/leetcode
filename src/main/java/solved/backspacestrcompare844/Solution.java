package solved.backspacestrcompare844;

class Solution {
    public boolean backspaceCompare(String s, String t) {

        return getString(s).equals(getString(t));
    }

    private String getString(String s) {
        int del = 0;
        for (int i = s.length() - 1; i >= 0;) {
            if (s.charAt(i) == '#') {
                del++;
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
            } else {
                if (del > 0) {
                    if (i + 1 <= del) {
                        s = "" + s.substring(i + 1);
                        break;
                    }

                    for (int j = 0, m = del; j < m; j++) {
                        if (i < 0) {
                            return s;
                        }
                        if (s.charAt(i) == '#') {
                            s = s.substring(0, i) + s.substring(i + 1);
                            m++;
                            del++;
                            i--;
                        } else {
                            s = i == s.length() -1 ? s.substring(0, i) : s.substring(0, i) + s.substring(i + 1);
                            i--;
                            del--;
                        }
                    }

                } else {
                    i--;
                }
            }
        }
        return s;
    }
}
