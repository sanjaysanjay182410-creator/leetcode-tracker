// Last updated: 9/23/2026, 2:50:16 PM
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left to make room for the next bit
            result <<= 1;
            // Extract the least significant bit of n and add it to result
            result |= (n & 1);
            // Shift n right to process next bit
            n >>= 1;
        }
        return result;
    }
}