// Last updated: 9/23/2026, 2:44:09 PM
import java.util.*;

class Solution {

    class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        if (heightMap == null ||
            heightMap.length < 3 ||
            heightMap[0].length < 3) {
            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Min Heap
        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a, b) -> a.height - b.height
        );

        // Add all boundary cells
        for (int r = 0; r < rows; r++) {

            pq.offer(new Cell(r, 0, heightMap[r][0]));
            pq.offer(new Cell(r, cols - 1, heightMap[r][cols - 1]));

            visited[r][0] = true;
            visited[r][cols - 1] = true;
        }

        for (int c = 1; c < cols - 1; c++) {

            pq.offer(new Cell(0, c, heightMap[0][c]));
            pq.offer(new Cell(rows - 1, c, heightMap[rows - 1][c]));

            visited[0][c] = true;
            visited[rows - 1][c] = true;
        }

        int water = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {

            Cell current = pq.poll();

            for (int[] dir : directions) {

                int nr = current.row + dir[0];
                int nc = current.col + dir[1];

                // Outside the matrix
                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols ||
                    visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                int neighborHeight = heightMap[nr][nc];

                // Water trapped
                if (neighborHeight < current.height) {
                    water += current.height - neighborHeight;
                }

                // New boundary height
                int newHeight = Math.max(
                    current.height,
                    neighborHeight
                );

                pq.offer(
                    new Cell(nr, nc, newHeight)
                );
            }
        }

        return water;
    }
}