package solved.problem1to999._1to99._30to39.findSubstring30;


import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for (String word:words) {
            map.putIfAbsent(word,0);
            map.compute(word,(k,v)->v+1);
        }
        List<Integer> res = new ArrayList<>();
        int length = words[0].length();
        int width = length * words.length;
        for (int i=0;i<=s.length()-width;i++) {
            int right=i+width;
            int j;
            Map<String,Integer> tempMap = new HashMap<>(map);
            for (j=i;j<right;j+=length) {
                String sub = s.substring(j,j+length);
                if (!tempMap.containsKey(sub) || tempMap.get(sub)<=0) {
                    break;
                }
                tempMap.compute(sub, (k,v)->v-1);
            }
            if (j==right) {
                res.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }
}
