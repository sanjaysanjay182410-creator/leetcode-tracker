// Last updated: 9/23/2026, 2:49:03 PM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Since houses are in a circle:
        // Case 1: Rob houses 0 to n-2
        // Case 2: Rob houses 1 to n-1
        return Math.max(
            robRange(nums, 0, n - 2),
            robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}