package solved.problem1001to2000._1401to1500.destCity1436;

import java.util.*;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startCity = new HashSet<>();
        for (List<String> path:paths) {
            startCity.add(path.get(0));
        }
        for (List<String> path:paths) {
            if (!startCity.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.destCity(Arrays.asList(Arrays.asList("London","New York"), Arrays.asList("New York","Lima"), Arrays.asList("Lima","Sao Paulo"))));
    }
}
