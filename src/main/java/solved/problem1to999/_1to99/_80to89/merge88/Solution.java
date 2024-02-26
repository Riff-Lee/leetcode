package solved.problem1to999._1to99._80to89.merge88;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0){
            for (int i = 0; i<m+n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int index1 = 0;
        int index2 = 0;
        int[] temp = new int[m+n];
        int index = 0;
        while (index1<m && index2<n) {
            if (nums1[index1]<nums2[index2]) {
                temp[index++] = nums1[index1++];
            } else {
                temp[index++] = nums2[index2++];
            }
        }
        if (index1 == m) {
            while (index<m+n) {
                temp[index++] = nums2[index2++];
            }
        } else {
            while (index<m+n) {
                temp[index++] = nums1[index1++];
            }
        }
        for (int i = 0; i<m+n; i++) {
            nums1[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{0,0,0},3,new int[]{1,2,3},3);
    }
}
