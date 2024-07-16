package solved.problem1000to1999._1600to1699.furthestBuilding1642;

import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 1; i < heights.length; i++) {
            heights[i-1] = Math.max(heights[i] - heights[i-1],0);
        }
        int res = 0;
        if (ladders==0) {
            for (int i=0;i<heights.length-1;i++)  {
                bricks-=heights[i];
                if (bricks<0){
                    break;
                }
                res++;
            }
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0;i<heights.length-1;i++)  {
            if (heights[i]>0) {
                if (queue.size()<ladders) {
                    queue.add(heights[i]);
                } else {
                    int min = queue.poll();
                    if (min >= heights[i]) {
                        queue.add(min);
                        bricks-=heights[i];
                    } else {
                        queue.add(heights[i]);
                        bricks-=min;
                    }
                }
            }
            if (bricks<0){
                break;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.furthestBuilding(new int[]{14,3,19,3}, 17, 0));
    }
}
