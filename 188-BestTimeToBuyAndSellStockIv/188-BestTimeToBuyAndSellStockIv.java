// Last updated: 9/23/2026, 2:50:20 PM
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        
        // If k is large enough, it's equivalent to unlimited transactions (problem 122)
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        // dp[j][0] = max profit after j transactions, not holding stock
        // dp[j][1] = max profit after j transactions, holding stock
        int[][] dp = new int[k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[j][1] = -prices[0];  // buy on day 0
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // not holding: keep not holding, or sell what we held
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
                // holding: keep holding, or buy (using j-1 transactions' not-holding state)
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
            }
        }
        
        return dp[k][0];
    }
}