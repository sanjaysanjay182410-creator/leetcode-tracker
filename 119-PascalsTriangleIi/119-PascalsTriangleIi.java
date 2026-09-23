// Last updated: 9/23/2026, 2:53:20 PM
import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            // Build from right to left to avoid overwriting values we still need
            for (int j = row.size() - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);  // add the trailing 1
        }

        return row;
    }
}