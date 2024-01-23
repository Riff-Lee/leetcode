package unsolved.maxLength1239;

import java.util.*;

class Solution {
    int maxLength = 0;
    public int maxLength(List<String> arr) {

        backTrack(arr, 0, 0);
        return maxLength;
    }

    private void backTrack(List<String> arr, int index, int charSet) {
        if (index == arr.size()) {
            int count = 0;
            for (int i = 0; i < 26; ++i) {
                if ((charSet & (1 << i)) != 0) {
                    count++;
                }
            }
            maxLength = Math.max(maxLength, count);
            return;
        }

        int newCharSet = charSet;
        boolean isValidString = true;

        for (char ch : arr.get(index).toCharArray()) {
            int bit = 1 << (ch - 'a');
            if ((newCharSet & bit) == 0) {
                newCharSet |= bit;
            } else {
                isValidString = false;
                break;
            }
        }

        if (isValidString) {
            backTrack(arr, index + 1, newCharSet);
        }

        backTrack(arr, index + 1, charSet);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLength(List.of("un","iq","ue")));
    }
}
