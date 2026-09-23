// Last updated: 9/23/2026, 2:43:04 PM
class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] selected = new int[k];
        for (int i = 0; i < k; i++) {
            selected[i] = nums[n - k + i];
        }
        Arrays.sort(selected);
        long total = 0;
        int currentMul = mul;

        for (int i = k - 1; i >=0; i--){
            if(currentMul > 1){
                total += (long) selected[i] * currentMul;
            } else {
                total += selected[i];
            }
            currentMul--;
        }

        return total;
        
    }
}