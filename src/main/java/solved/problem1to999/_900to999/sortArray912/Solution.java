package solved.problem1to999._900to999.sortArray912;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public int[] quickSort(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    public int[] quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }
        int pivot = divide(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
        return nums;
    }

    private int divide(int[] nums, int start, int end) {
        int base = nums[start];
        int prev = start;
        int cur = start + 1;
        while (cur <= end) {
            if (nums[cur] < base) {
                prev++;
                swap(nums, prev, cur);
            }
            cur++;
        }
        swap(nums, prev, start);
        return prev;
    }

    // O(nlogn)
    public int[] mergeSort(int[] nums) {
        for (int step = 1; step < nums.length; step *= 2) {
            for (int i = 0; i < nums.length - step; i += 2 * step) {
                merge(nums, i, i + step - 1, Math.min(i + step + step - 1, nums.length - 1));
            }
        }
        return nums;
        //return mergeSort(nums, 0 , nums.length - 1);
    }

    public int[] mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = ((right - left) >> 1) + left;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
        return nums;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int l1 = left;
        int l2 = mid + 1;
        int[] newArr = new int[right - left + 1];
        int i = 0;
        while (i < newArr.length && l1 <= mid && l2 <= right) {
            if (nums[l1] < nums[l2]) {
                newArr[i++] = nums[l1++];
            } else {
                newArr[i++] = nums[l2++];
            }
        }

        while (i < newArr.length && l1 <= mid) {
            newArr[i++] = nums[l1++];
        }
        while (i < newArr.length && l2 <= right) {
            newArr[i++] = nums[l2++];
        }

        for (int k : newArr) {
            nums[left++] = k;
        }
    }

    public int[] heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }

        return nums;
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k + 1] > nums[k]) {
                k += 1;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }


    // O(n^2)
    // Optimization 1. Set a flag to observe whether swapping has occurred in the internal loop. If no swapping has occurred, it indicates that the array is already ordered and there is no need for subsequent comparison and swapping operations
    // Optimization 2. Record the position of the last exchange, as all elements after that are ordered, and the next scan only needs to scan to this position
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    // O(n^2)
    // mini Optimization: Obtain both the minimum and maximum values within a loop, and perform two swaps based on the situation
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    // O(n^2)
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >= 0 && temp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    // special insertion sort
    // O(n^(1.3-2))
    public int[] shellSort(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
            gap /= 2;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        // consider overflow
//        nums[i] = nums[i]+nums[j];
//        nums[j] = nums[i]-nums[j];
//        nums[i] = nums[i]-nums[j];

        // i!=j
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Random rand = new Random();
        int size = 10000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        int[] arr1;
        int[] arr2;

        // check bubble sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.bubbleSort(arr2)));

        // check selection sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.selectionSort(arr2)));

        // check insertion sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.insertionSort(arr2)));

        // check shell sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.shellSort(arr2)));

        // check merge sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.mergeSort(arr2)));

        // check quick sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.quickSort(arr2)));

        // check heap sort
        arr1 = Arrays.copyOf(arr, size);
        arr2 = Arrays.copyOf(arr, size);
        System.out.println(Arrays.equals(solution.sortArray(arr1), solution.heapSort(arr2)));

        System.out.println();
    }

}
