package solved.problem1to999._1to99._60to69.fullJustify68;

import java.util.*;
import java.util.stream.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int width=0;
        List<String> rows = new ArrayList<>();
        int num=0;
        for (String word:words) {
            if (width+word.length()+num>maxWidth) {
                if (num==1) {
                    res.add(rows.get(0)+" ".repeat(maxWidth-rows.get(0).length()));
                } else {
                    int space = (maxWidth-width)/(num-1);
                    int mod = (maxWidth-width)%(num-1);
                    String row;
                    if (mod==0) {
                        row = String.join(" ".repeat(space), rows);
                    } else {
                        row = rows.stream()
                                .limit(mod)
                                .map(item -> item + " ".repeat(space+1))
                                .collect(Collectors.joining())
                                + rows.stream()
                                .skip(mod)
                                .map(item -> item + " ".repeat(space))
                                .collect(Collectors.joining());
                    }
                    res.add(row.trim());
                }
                width=0;
                num=0;
                rows = new ArrayList<>();
            }
            width+=word.length();
            num++;
            rows.add(word);
        }
        if (num!=0) {
            String row = String.join(" ", rows);
            row = row + " ".repeat(maxWidth-width-num+1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
