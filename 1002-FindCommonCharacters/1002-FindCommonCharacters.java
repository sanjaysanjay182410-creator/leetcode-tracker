// Last updated: 9/23/2026, 2:42:58 PM
import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            // Keep the minimum count across all words
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }
}