package solved.problem1to1000._201to300._221to230.majorityElement229;

import java.util.*;

class Solution {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> ele = new HashMap<>();
        for (int num : nums) {
            ele.computeIfPresent(num, (k,v)->v+1);
            ele.putIfAbsent(num, 1);
        }
        int k = nums.length/3;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : ele.entrySet()) {
            if (k<entry.getValue()) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3,2,3}));
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