package solved.problem1001to2000._1001to1100.findInMountainArray1095;

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainIndex = getMountainIndex(mountainArr);
        if (target == mountainArr.get(mountainIndex)) {
            return mountainIndex;
        }
        if (target > mountainArr.get(mountainIndex)||(target<mountainArr.get(0)&&target<mountainArr.get(mountainArr.length()-1))) {
            return -1;
        }
        int left = findLeft(mountainArr, mountainIndex, target);
        if (left != -1) {
            return left;
        }
        return findRight(mountainArr, mountainIndex, target);
    }

    private int findRight(MountainArray mountainArr, int mountainIndex, int target) {
        int left = mountainIndex+1;
        int right = mountainArr.length()-1;
        while (left<right) {
            int mid = left + ((right-left)>>1);
            if (mountainArr.get(mid)==target) {
                return mid;
            }
            if (mountainArr.get(mid)>target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left)==target? left:-1;
    }

    private int findLeft(MountainArray mountainArr, int mountainIndex, int target) {
        int left = 0;
        int right = mountainIndex-1;
        while (left<right) {
            int mid = left + ((right-left)>>1);
            if (mountainArr.get(mid)==target) {
                return mid;
            }
            if (mountainArr.get(mid)<target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left)==target? left:-1;
    }

    private int getMountainIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length()-1;
        while (true) {
            int mid = left + ((right-left)>>1);
            if (mountainArr.get(mid-1)<mountainArr.get(mid) && mountainArr.get(mid+1)<mountainArr.get(mid)) {
                return mid;
            }
            if (mountainArr.get(mid-1)<mountainArr.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
    }

    static class MountainArray {
        int[] arr = {0,5,3,1};
        public int get(int index) {
            return arr[index];
        }
        public int length() {
            return arr.length;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findInMountainArray(1,new MountainArray()));
    }
}
