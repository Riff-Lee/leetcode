package solved.problem1to1000._401to500.frequencySort451;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch:s.toCharArray()) {
            map.computeIfPresent(ch,(k,v)->v+1);
            map.putIfAbsent(ch,1);
        }
        Map<Integer, List<Character>> charMap = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.equals(o2) ? 0:o1>o2?-1:1;
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!charMap.containsKey(entry.getValue())) {
                charMap.put(entry.getValue(), new ArrayList<>());
                queue.add(entry.getValue());
            }
            charMap.get(entry.getValue()).add(entry.getKey());
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (char ch : charMap.get(num)) {
                stringBuilder.append(String.valueOf(ch).repeat(num));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}
