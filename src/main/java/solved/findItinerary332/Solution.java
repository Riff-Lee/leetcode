package solved.findItinerary332;

import java.util.*;

class Solution {
    static class Graph {
        private String name;
        private Graph[] children;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> fromTo = new HashMap<>();
        for (List<String> ticket : tickets) {
            fromTo.putIfAbsent(ticket.get(0), new ArrayList<>());
            fromTo.computeIfPresent(ticket.get(0), (k,v)->{
                v.add(ticket.get(1));
                return v;
            });
        }

        for (List<String> v : fromTo.values()) {
            v.sort(String::compareTo);
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");
        help(res, fromTo, "JFK");
        return res;
    }

    private void help(List<String> res, Map<String, List<String>> fromTo, String from) {
        List<String> tos = fromTo.get(from);
        if (tos==null || tos.isEmpty()) {
            return;
        }
        String to = tos.get(0);
        res.add(to);
        tos.remove(0);
        help(res, fromTo, to);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findItinerary(List.of(List.of("JFK","KUL"), List.of("JFK","NRT"), List.of("NRT","JFK"))));
    }
}
