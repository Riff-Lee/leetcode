package solved.problem2000to2999._2000to2099.findAllPeople2092;

import java.util.*;

class Solution {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, Meeting> map = new HashMap<>();
        for (int[] m : meetings) {
            Meeting meeting = map.get(m[2]);
            if (meeting == null) {
                meeting = new Meeting(m[2]);
                map.put(m[2], meeting);
            }
            meeting.meetings.add(m);
        }
        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        map.forEach((k, v) -> queue.add(v));
        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        while (!queue.isEmpty() || res.size() == n) {
            Meeting meeting = queue.poll();
            if (meeting == null || meeting.meetings == null || meeting.meetings.isEmpty()) {
                continue;
            }
            Map<Integer, Set<Integer>> dumpling = new HashMap<>();
            for (int[] m : meeting.meetings) {
                Set<Integer> d1 = dumpling.get(m[0]);
                Set<Integer> d2 = dumpling.get(m[1]);
                if (d1 == null) {
                    d1 = new HashSet<>();
                    d1.add(m[0]);
                    dumpling.put(m[0], d1);
                }
                if (d2 == null) {
                    d2 = new HashSet<>();
                    d2.add(m[1]);
                    dumpling.put(m[1], d2);
                }
                d1.addAll(d2);
                dumpling.put(m[1], d1);
            }
            dumpling.forEach((k,v)->{
                Set<Integer> copy = new HashSet<>(v);
                copy.retainAll(res);
                if (!copy.isEmpty()) {
                    res.addAll(v);
                }
            });
        }
        return new ArrayList<>(res);
    }

    static class Meeting implements Comparable<Meeting> {
        int time;
        Set<int[]> meetings;

        public Meeting(int time) {
            this.time = time;
            this.meetings = new HashSet<>();
        }

        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(this.time - o.time, 0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.findAllPeople(6, new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}}, 1);
        System.out.println(res);
    }


}
