// Last updated: 9/23/2026, 2:43:02 PM
class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';
            count[index]++;

            // Most frequent character in the window
            maxFreq = Math.max(maxFreq, count[index]);

            // Characters that need replacement
            int windowLength = right - left + 1;
            int replacements = windowLength - maxFreq;

            // If more than k replacements are needed
            if (replacements > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}