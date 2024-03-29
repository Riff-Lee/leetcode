package solved.problem2000to2999._2900to2999.countSubarrays2962;


import java.util.Arrays;

public class Solution {

    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0, n = nums.length;
        for (int num : nums)
            max = Math.max(max, num);
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                res += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
        }
        return res;
    }

    public long countSubarrays2(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0,r=0,n=nums.length;

        while (r < n) {
            k -= nums[r] == mx ? 1 : 0;
            r++;
            while (k == 0) {
                k += nums[l] == mx ? 1 : 0;
                l++;
            }
            ans += l;
        }

        return ans;
    }

    public long countSubarrays1(int[] nums, int k) {
        int max = 0;
        int maxCount = 0;
        int n = nums.length;
        for (int num : nums) {
            if (max < num) {
                max = num;
                maxCount = 1;
            } else if (max == num) {
                maxCount++;
            }
        }
        if (maxCount<k) {
            return 0;
        }
        int[] maxIndex = new int[maxCount+2];
        maxIndex[0] = -1;
        maxIndex[maxCount+1] = n;
        int count = 1;
        for (int i=0;i<nums.length&&count<maxCount+1;i++) {
            if (max==nums[i]) {
                maxIndex[count++] = i;
            }
        }
        int step=k;
        long res = 0;
        while (step<=maxCount) {
            for (int left=1,right=step;right<maxCount+1;left++,right++) {
                res+=(long)(maxIndex[left]-maxIndex[left-1])*(long)(maxIndex[right+1]-maxIndex[right]);
            }
            step++;
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(new int[] {1,3,2,3,3}, 2));
    }
}
