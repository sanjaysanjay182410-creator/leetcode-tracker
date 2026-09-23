// Last updated: 9/23/2026, 2:44:35 PM
class Solution {
    public int findNthDigit(int n) {

        long digitLength = 1;
        long count = 9;
        long start = 1;

        // Find the range containing n
        while (n > digitLength * count) {
            n -= digitLength * count;

            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number
        long number = start + (n - 1) / digitLength;

        // Find the digit inside the number
        int index = (int) ((n - 1) % digitLength);

        String s = String.valueOf(number);

        return s.charAt(index) - '0';
    }
}