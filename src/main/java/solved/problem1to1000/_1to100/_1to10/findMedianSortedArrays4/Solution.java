package solved.problem1to1000._1to100._1to10.findMedianSortedArrays4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int low= 0;
        int high = n1;
        int mid1 = 0, mid2=0;
        int n = n1+ n2;
        int leftSide = (n+1)/2;
        while(low<=high){
            mid1 = (high+low) / 2;
            mid2 = leftSide - mid1;
            int L1 = Integer.MIN_VALUE, L2 = Integer.MIN_VALUE;
            int R1 = Integer.MAX_VALUE, R2 = Integer.MAX_VALUE;
            if(mid1-1 >= 0) L1 = nums1[mid1-1];
            if(mid1 < n1) R1 = nums1[mid1];
            if(mid2-1 >= 0) L2 = nums2[mid2-1];
            if(mid2 < n2) R2 = nums2[mid2];

            if(L1<=R2 && L2 <= R1){
                if(n%2 == 0){
                    return (double)(Math.max(L1, L2) + Math.min(R1, R2))/2;
                }else{
                    return (double)(Math.max(L1,L2));
                }
            }else if(L1>R2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }

        return 0.0;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n)/2 + 1;
        int[] merge = new int[half];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n && k < half) {
            if (nums1[i] < nums2[j]) {
                merge[k++] = nums1[i++];
            } else {
                merge[k++] = nums2[j++];
            }
        }

        for (; k < half; k++) {
            if (i == m) {
                merge[k] = nums2[j++];
            } else {
                merge[k] = nums1[i++];
            }
        }
        return (m+n) % 2 == 0 ? (double) (merge[half-1] + merge[half-2])/2 : (double) merge[half-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1,3}, new int[2]));
    }
}
