package solved.problem1to1000._301to400.RandomizedSet380;

import java.util.*;

public class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    Random random = new Random();
    int n = 0;
    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (set.add(val)) {
            list.add(val);
            n++;
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (set.remove(val)) {
            list.remove(Integer.valueOf(val));
            n--;
            return true;
        }
        return false;
    }

    public int getRandom() {
        int index = random.nextInt(n);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */