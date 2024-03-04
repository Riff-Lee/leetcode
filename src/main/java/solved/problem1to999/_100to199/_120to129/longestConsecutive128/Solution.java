package solved.problem1to999._100to199._120to129.longestConsecutive128;


import java.util.PriorityQueue;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num:nums) {
            queue.add(num);
        }
        int res = 1;
        int numbers = 1;
        int last = queue.poll();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current==last+1) {
                numbers++;
            } else if (current!=last) {
                res=Math.max(numbers,res);
                numbers=1;
            }
            last=current;
        }
        return Math.max(numbers,res);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }
}
