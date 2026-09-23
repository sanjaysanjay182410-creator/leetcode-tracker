// Last updated: 9/23/2026, 2:53:35 PM
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Empty t can be formed from any prefix of s in 1 way (delete all)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Match: either use this character or skip it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // No match: skip character in s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}