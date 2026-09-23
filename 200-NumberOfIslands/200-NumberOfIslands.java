// Last updated: 9/23/2026, 2:49:48 PM
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);  // sink the entire island
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        // Bounds check + water check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
            || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';  // mark visited by sinking
        dfs(grid, r + 1, c);  // down
        dfs(grid, r - 1, c);  // up
        dfs(grid, r, c + 1);  // right
        dfs(grid, r, c - 1);  // left
    }
}