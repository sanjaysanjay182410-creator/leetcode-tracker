// Last updated: 7/9/2026, 10:06:49 AM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        // Find leftmost occurrence
        int leftIndex = findLeft(nums, target);
        
        // If target not found, return [-1, -1]
        if (leftIndex == -1) {
            return new int[]{-1, -1};
        }
        
        // Find rightmost occurrence
        int rightIndex = findRight(nums, target);
        
        return new int[]{leftIndex, rightIndex};
    }
    
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching on the left side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching on the right side
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}