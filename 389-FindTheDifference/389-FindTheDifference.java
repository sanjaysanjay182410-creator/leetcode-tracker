// Last updated: 9/23/2026, 2:45:49 PM
class Solution {
    public char findTheDifference(String s, String t) {

        int result = 0;

        // XOR all characters in s
        for (char c : s.toCharArray()) {
            result ^= c;
        }

        // XOR all characters in t
        for (char c : t.toCharArray()) {
            result ^= c;
        }

        return (char) result;
    }
}