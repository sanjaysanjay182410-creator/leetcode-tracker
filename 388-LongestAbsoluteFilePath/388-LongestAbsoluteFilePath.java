// Last updated: 9/23/2026, 2:45:53 PM
class Solution {
    public int lengthLongestPath(String input) {

        String[] lines = input.split("\n");

        // levelLength[i] = total path length up to level i
        int[] levelLength = new int[lines.length + 1];

        int maxLength = 0;

        for (String line : lines) {

            // Count the number of \t
            int level = 0;

            while (line.charAt(level) == '\t') {
                level++;
            }

            // Remove tabs
            String name = line.substring(level);

            // Length of current path
            levelLength[level + 1] =
                    levelLength[level] + name.length() + 1;

            // If it is a file
            if (name.contains(".")) {
                maxLength = Math.max(
                    maxLength,
                    levelLength[level + 1] - 1
                );
            }
        }

        return maxLength;
    }
}