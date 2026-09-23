// Last updated: 9/23/2026, 2:46:36 PM
import java.util.Random;

class Solution {
    private int[] original;
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.original = nums.clone();
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        // Fisher-Yates: iterate from end, swap each element with a random
        // one chosen from indices 0..i (inclusive)
        for (int i = nums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}