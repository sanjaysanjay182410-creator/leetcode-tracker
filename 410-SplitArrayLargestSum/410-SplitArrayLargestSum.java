// Last updated: 9/23/2026, 2:44:04 PM
class Solution {
    public int splitArray(int[] nums, int k) {

        long left = 0;
        long right = 0;

        // Find the search range
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Binary search
        while (left < right) {

            long mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (int) left;
    }

    private boolean canSplit(int[] nums, int k, long maxSum) {

        int parts = 1;
        long currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                parts++;
                currentSum = num;

                if (parts > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}