// Last updated: 9/23/2026, 2:48:51 PM
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If number already exists within last k elements
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Keep only k elements in the window
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
