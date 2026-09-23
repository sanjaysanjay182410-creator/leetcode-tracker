// Last updated: 9/23/2026, 2:52:49 PM
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        
        int longest = 0;
        
        for (int num : set) {
            // Only start counting if num-1 is NOT in the set (start of a sequence)
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                
                longest = Math.max(longest, length);
            }
        }
        
        return longest;
    }
}