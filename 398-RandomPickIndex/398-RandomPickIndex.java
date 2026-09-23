// Last updated: 9/23/2026, 2:44:46 PM
import java.util.*;

class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {

        int result = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                count++;

                // Pick this index with probability 1/count
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}