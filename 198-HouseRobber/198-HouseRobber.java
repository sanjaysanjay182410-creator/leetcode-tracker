// Last updated: 9/23/2026, 2:49:57 PM
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int prev2 = 0;          // max money up to i-2
        int prev1 = nums[0];    // max money up to i-1
        
        for (int i = 1; i < n; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}