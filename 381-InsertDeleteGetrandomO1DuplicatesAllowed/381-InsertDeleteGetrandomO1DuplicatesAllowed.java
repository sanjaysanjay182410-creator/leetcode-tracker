// Last updated: 9/23/2026, 2:46:46 PM
import java.util.*;

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> indexMap;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notContains = !indexMap.containsKey(val);
        if (notContains) {
            indexMap.put(val, new HashSet<>());
        }
        indexMap.get(val).add(list.size());
        list.add(val);
        return notContains;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val) || indexMap.get(val).isEmpty()) {
            return false;
        }

        // Get an index of val to remove
        int index = indexMap.get(val).iterator().next();
        indexMap.get(val).remove(index);

        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        if (index != lastIndex) {
            // Move last element to the removed position
            list.set(index, lastVal);
            indexMap.get(lastVal).remove(lastIndex);
            indexMap.get(lastVal).add(index);
        }

        list.remove(lastIndex);

        // Clean up empty set
        if (indexMap.get(val).isEmpty()) {
            indexMap.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}