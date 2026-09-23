// Last updated: 9/23/2026, 2:43:17 PM
class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        // Find total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Odd sum cannot be divided equally
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[i] = true if sum i can be formed
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {

            // Go backwards to avoid using same number twice
            for (int sum = target; sum >= num; sum--) {

                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }
}