// Last updated: 9/23/2026, 2:44:55 PM
class Solution {
    public int maxRotateFunction(int[] nums) {

        int n = nums.length;

        long sum = 0;
        long f = 0;

        // Calculate sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;

        // Calculate F(1), F(2), ...
        for (int k = 1; k < n; k++) {

            f = f + sum - (long) n * nums[n - k];

            max = Math.max(max, f);
        }

        return (int) max;
    }
}