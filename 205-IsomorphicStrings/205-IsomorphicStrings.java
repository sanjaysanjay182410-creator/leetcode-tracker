// Last updated: 9/23/2026, 2:49:31 PM
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (mapS[a] != mapT[b]) {
                return false;
            }

            mapS[a] = i + 1;
            mapT[b] = i + 1;
        }

        return true;
    }
}