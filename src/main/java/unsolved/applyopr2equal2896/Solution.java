package unsolved.applyopr2equal2896;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minOperations(String s1, String s2, int x) {
        int b1 = Integer.parseInt(s1, 2);
        int b2 = Integer.parseInt(s2, 2);

        String binaryString = Integer.toBinaryString(b1^b2);
        List<Integer> flipIndex = new ArrayList<>();
        for (int i = 0; i< binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                flipIndex.add(i);
            }
        }
        if (flipIndex.size() % 2 != 0) {
            return -1;
        }


        return 0;
    }

}
