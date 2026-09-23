// Last updated: 9/23/2026, 2:44:05 PM
class Solution {
    public int longestPalindrome(String s) {

        int[] count = new int[128];

        // Count each character
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int c : count) {

            // Use the largest even portion
            length += (c / 2) * 2;

            // One odd character can be placed in the center
            if (c % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length++;
        }

        return length;
    }
}