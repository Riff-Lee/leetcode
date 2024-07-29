package solved.problem1000to1999._1600to1699.frequencySort1636;

import java.util.Arrays;

class Solution {
    public int[] frequencySort(int[] nums) {
        Frequency[] frequencies = new Frequency[201];
        for (int num : nums) {
            if (frequencies[num+100] == null) {
                frequencies[num+100] = new Frequency(num);
            }
            frequencies[num+100].freq += 1;
        }
        Arrays.sort(frequencies, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }

            if (o2 == null) {
                return -1;
            }
            if (o1.freq == o2.freq) {
                return Integer.compare(o2.num, o1.num);
            }
            return Integer.compare(o1.freq, o2.freq);
        });
        int[] res = new int[nums.length];
        int i = 0;
        for (Frequency frequency : frequencies) {
            if (frequency == null) {
                break;
            }
            for (int add = 0; add < frequency.freq; add++) {
                res[i + add] = frequency.num;
            }
            i += frequency.freq;
        }
        return res;
    }

    static class Frequency {
        int freq;
        int num;

        Frequency(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1}));
    }
}
