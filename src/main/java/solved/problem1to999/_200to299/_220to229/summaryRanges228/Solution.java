package solved.problem1to999._200to299._220to229.summaryRanges228;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length==0) {
            return res;
        }
        int left = nums[0];
        int i=1;
        for (;i<nums.length;i++) {
            if (nums[i-1] != nums[i] - 1) {
                if (left == nums[i-1]) {
                    res.add(String.valueOf(left));
                } else {
                    res.add(left + "->" + nums[i-1]);
                }
                left = nums[i];
            }
        }
        if (left==nums[i-1]) {
            res.add(String.valueOf(left));
        } else {
            res.add(left+"->"+nums[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[] {0,1,2,4,5,7}));
    }
}



/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */