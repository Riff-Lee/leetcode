package solved.problem1001to2000._1601to1700._1661to1670.check2strarrequal1662;

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        for (String w : word1) {
            w1.append(w);
        }
        StringBuilder w2 = new StringBuilder();
        for (String w : word2) {
            w2.append(w);
        }
        return w1.toString().equals(w2.toString());
    }
}
