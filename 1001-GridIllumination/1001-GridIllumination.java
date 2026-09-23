// Last updated: 9/23/2026, 2:42:56 PM
import java.util.*;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        // Hash maps to track counts per row, column, and diagonals
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();  // row - col
        Map<Integer, Integer> anti = new HashMap<>();  // row + col
        
        // Use a set of longs to represent lamps (avoid duplicates)
        Set<Long> lampSet = new HashSet<>();
        
        // Map a lamp to a unique long: r * n + c could overflow for large n,
        // so use (long) r << 32 | c
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long key = ((long) r << 32) | c;
            if (lampSet.contains(key)) continue; // skip duplicates
            lampSet.add(key);
            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag.put(r - c, diag.getOrDefault(r - c, 0) + 1);
            anti.put(r + c, anti.getOrDefault(r + c, 0) + 1);
        }
        
        int m = queries.length;
        int[] res = new int[m];
        
        for (int i = 0; i < m; i++) {
            int r = queries[i][0], c = queries[i][1];
            
            // Check if illuminated
            if (row.getOrDefault(r, 0) > 0 ||
                col.getOrDefault(c, 0) > 0 ||
                diag.getOrDefault(r - c, 0) > 0 ||
                anti.getOrDefault(r + c, 0) > 0) {
                res[i] = 1;
            }
            
            // Turn off surrounding 3x3 lamps
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    int nr = r + dr;
                    int nc = c + dc;
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    long key = ((long) nr << 32) | nc;
                    if (lampSet.contains(key)) {
                        lampSet.remove(key);
                        row.put(nr, row.get(nr) - 1);
                        col.put(nc, col.get(nc) - 1);
                        diag.put(nr - nc, diag.get(nr - nc) - 1);
                        anti.put(nr + nc, anti.get(nr + nc) - 1);
                    }
                }
            }
        }
        
        return res;
    }
}