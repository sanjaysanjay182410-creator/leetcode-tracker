// Last updated: 9/23/2026, 2:47:18 PM
class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long base = 1; base <= n; base *= 10) {
            long high = n / (base * 10);
            long cur = (n / base) % 10;
            long low = n % base;
            
            if (cur == 0) {
                count += high * base;
            } else if (cur == 1) {
                count += high * base + low + 1;
            } else { // cur > 1
                count += (high + 1) * base;
            }
        }
        return count;
    }
}