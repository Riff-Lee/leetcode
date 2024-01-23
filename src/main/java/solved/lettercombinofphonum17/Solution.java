package solved.lettercombinofphonum17;

import java.util.*;

public class Solution {
    Map<Character, String[]> map = Map.of(
            '2', new String[]{"a","b","c"},
            '3', new String[]{"d","e","f"},
            '4', new String[]{"g","h","i"},
            '5', new String[]{"j","k","l"},
            '6', new String[]{"m","n","o"},
            '7', new String[]{"p","q","r","s"},
            '8', new String[]{"t","u","v"},
            '9', new String[]{"w","x","y","z"});
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        letterCombinations(digits, res, new StringBuilder(), 0);
        return res;
    }
    private void letterCombinations(String digits, List<String> res, StringBuilder cur, int curInx) {
        if (curInx == digits.length()) {
            res.add(cur.toString());
        } else {
            String[] value = map.get(digits.charAt(curInx));
            for (int j = 0; j < value.length; j++) {
                cur.append(value[j]);
                letterCombinations(digits, res, cur, curInx+1);
                cur.deleteCharAt(cur.length()-1);
            }
        }

    }

}
