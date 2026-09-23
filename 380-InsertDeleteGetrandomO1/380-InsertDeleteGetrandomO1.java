// Last updated: 9/23/2026, 2:46:48 PM
import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> indexMap;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        int index = indexMap.get(val);
        int lastVal = list.get(list.size() - 1);

        // Swap the last element into the removed position, then pop.
        list.set(index, lastVal);
        indexMap.put(lastVal, index);
        list.remove(list.size() - 1);
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}