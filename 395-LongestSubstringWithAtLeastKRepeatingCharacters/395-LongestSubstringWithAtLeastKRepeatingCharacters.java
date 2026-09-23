// Last updated: 9/23/2026, 2:44:58 PM
class Solution {
    public int longestSubstring(String s, int k) {

        if (s.length() == 0 || k > s.length()) {
            return 0;
        }

        return solve(s, 0, s.length() - 1, k);
    }

    private int solve(String s, int left, int right, int k) {

        if (right - left + 1 < k) {
            return 0;
        }

        int[] count = new int[26];

        // Count characters
        for (int i = left; i <= right; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find a character that occurs less than k times
        for (int i = left; i <= right; i++) {

            if (count[s.charAt(i) - 'a'] < k) {

                char bad = s.charAt(i);

                // Split around the bad character
                int next = i + 1;

                while (next <= right &&
                       count[s.charAt(next) - 'a'] < k) {
                    next++;
                }

                int leftPart = solve(s, left, i - 1, k);
                int rightPart = solve(s, next, right, k);

                return Math.max(leftPart, rightPart);
            }
        }

        // Every character appears at least k times
        return right - left + 1;
    }
}