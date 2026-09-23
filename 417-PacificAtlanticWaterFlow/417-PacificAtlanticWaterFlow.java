// Last updated: 9/23/2026, 2:43:15 PM
import java.util.*;

class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top and left
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, rows - 1, c);
        }

        // Atlantic: bottom and right
        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, cols - 1);
        }

        // Find cells reachable by both oceans
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(
                        Arrays.asList(r, c)
                    );
                }
            }
        }

        return result;
    }

    private void dfs(
            int[][] heights,
            boolean[][] visited,
            int r,
            int c) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {

            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // We can move from lower/equal height
            // to higher/equal height.
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, visited, nr, nc);
            }
        }
    }
}