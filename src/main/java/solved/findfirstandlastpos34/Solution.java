package solved.findfirstandlastpos34;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {-1, -1};
        }
        if (n == 1) {
            if (nums[0] == target) {
                return new int[] {0, 0};
            } else {
                return new int[] {-1, -1};
            }
        }

        if (target < nums[0] || target > nums[n - 1]) {
            return new int[] {-1, -1};
        }
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[] {-1, -1};
        }
//        int last = first + 1;
//        while (nums[last] == target) {
//            last++;
//        }
        return new int[] {first, findLast(nums, target, first)};
    }

    private int findLast(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (true) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] <= target) {
                left = mid;
            }
            if (left >= right - 1) {
                if (nums[right] == target) {
                    return right;
                } else if (nums[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }
        }
    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
            if (left >= right - 1) {
                if (nums[left] == target) {
                    return left;
                } else if (nums[right] == target) {
                    return right;
                } else {
                    return -1;
                }
            }
        }
    }
}
