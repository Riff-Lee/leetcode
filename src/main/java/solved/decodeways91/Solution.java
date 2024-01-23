package solved.decodeways91;

public class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] str = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = Character.getNumericValue(s.charAt(i));
        }
        int[] nums = new int[s.length()];
        nums[0] = 1;
        if (str[0] == 1 || str[0] == 2) {
            if (str[1] == 0 || (str[0] == 2 && str[1] >= 7)) {
                nums[1] = 1;
            } else {
                nums[1] = 2;
            }
        } else {
            if (str[1] == 0) {
                return 0;
            } else {
                nums[1] = 1;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (str[i] == 0) {
                if (str[i-1] != 1 && str[i-1] !=2) {
                    return 0;
                }
                nums[i] = nums[i-2];
                continue;
            }
            if (str[i-1] == 1 || (str[i-1] == 2 && str[i] <= 6)) {
                nums[i] = nums[i-2] + nums[i-1];
            } else {
                nums[i] = nums[i-1];
            }

        }

        return nums[s.length() - 1];
    }

}
