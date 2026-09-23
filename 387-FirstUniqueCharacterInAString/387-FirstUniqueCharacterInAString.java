// Last updated: 9/23/2026, 2:45:58 PM
class Solution {
    public int firstUniqChar(String s) {

        int[] count = new int[26];

        // Count each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Find the first character with count = 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}