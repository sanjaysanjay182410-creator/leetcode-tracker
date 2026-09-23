// Last updated: 9/23/2026, 2:53:22 PM
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        // First row
        triangle.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element is always 1
            currentRow.add(1);

            // Middle elements: sum of two numbers above
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}