// Last updated: 9/23/2026, 2:45:44 PM
import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int area = 0;

        Set<String> corners = new HashSet<>();

        for (int[] r : rectangles) {

            int x1 = r[0];
            int y1 = r[1];
            int x2 = r[2];
            int y2 = r[3];

            // Find the outer boundary
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Calculate total area
            area += (x2 - x1) * (y2 - y1);

            // Process four corners
            String[] points = {
                x1 + "," + y1,
                x1 + "," + y2,
                x2 + "," + y1,
                x2 + "," + y2
            };

            for (String point : points) {

                if (!corners.add(point)) {
                    corners.remove(point);
                }
            }
        }

        // Area of the big rectangle
        int bigArea = (maxX - minX) * (maxY - minY);

        // The four outer corners must remain
        if (!corners.contains(minX + "," + minY) ||
            !corners.contains(minX + "," + maxY) ||
            !corners.contains(maxX + "," + minY) ||
            !corners.contains(maxX + "," + maxY)) {

            return false;
        }

        // There must be exactly 4 corners
        return corners.size() == 4 && area == bigArea;
    }
}