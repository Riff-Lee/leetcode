package unsolved.minswap2seqincreas801;

import java.util.Arrays;

public class Solution {

    public int minSwap(int[] A, int[] B) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // In this case, the ith manipulation should be same as the i-1th manipulation
                // fixRecord = fixRecord;
                swapRecord++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }


    public int minSwap1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                dp[i] = dp[i-1];
            } else if (i == 1 || i >= 2 && nums1[i-1] > nums2[i-2] && nums2[i-1] > nums1[i-2]) {

            }
            if (nums1[i] < nums1[i-1] || nums2[i] < nums2[i-1]) {
                dp[i] = dp[i-1] + 1;
                nums1[i] = nums1[i] ^ nums2[i];
                nums2[i] = nums1[i] ^ nums2[i];
                nums1[i] = nums1[i] ^ nums2[i];
            } else if (nums1[i] == nums1[i-1] || nums2[i] == nums2[i-1]) {
                if (i+1 == n) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    if ((nums1[i+1] > nums2[i] && nums2[i+1] > nums1[i]) || (i > 1 && (nums1[i-2] >= nums2[i-1] || nums2[i-2] >= nums1[i-1]))) {
                        dp[i] = dp[i-1] + 1;
                        nums1[i] = nums1[i] ^ nums2[i];
                        nums2[i] = nums1[i] ^ nums2[i];
                        nums1[i] = nums1[i] ^ nums2[i];
                    } else {
                        dp[i-1] = dp[i-1] + 1;
                        dp[i] = dp[i-1];
                        nums1[i-1] = nums1[i-1] ^ nums2[i-1];
                        nums2[i-1] = nums1[i-1] ^ nums2[i-1];
                        nums1[i-1] = nums1[i-1] ^ nums2[i-1];
                    }
                }
            } else {
                dp[i] = dp[i-1];
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        return dp[n-1] > n/2 ? n - dp[n-1] : dp[n-1];
    }
}
