// Last updated: 9/23/2026, 2:48:40 PM
import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long num = nums[i];

            // Find the smallest number >= num - valueDiff
            Long ceil = set.ceiling(num - (long) valueDiff);

            // Check if it is also <= num + valueDiff
            if (ceil != null && ceil <= num + (long) valueDiff) {
                return true;
            }

            set.add(num);

            // Keep only the last indexDiff elements
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
