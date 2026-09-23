// Last updated: 9/23/2026, 2:44:14 PM
import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        // Sort:
        // 1. Height descending
        // 2. k ascending
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        List<int[]> result = new ArrayList<>();

        // Insert each person at their k position
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][]);
    }
}