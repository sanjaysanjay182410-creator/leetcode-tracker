// Last updated: 9/23/2026, 2:45:04 PM
class Solution {
    public boolean validUtf8(int[] data) {

        int bytesToCheck = 0;

        for (int num : data) {

            // Keep only the last 8 bits
            num = num & 255;

            if (bytesToCheck == 0) {

                // 1-byte character: 0xxxxxxx
                if ((num >> 7) == 0) {
                    bytesToCheck = 0;
                }

                // 2-byte character: 110xxxxx
                else if ((num >> 5) == 0b110) {
                    bytesToCheck = 1;
                }

                // 3-byte character: 1110xxxx
                else if ((num >> 4) == 0b1110) {
                    bytesToCheck = 2;
                }

                // 4-byte character: 11110xxx
                else if ((num >> 3) == 0b11110) {
                    bytesToCheck = 3;
                }

                // Invalid starting byte
                else {
                    return false;
                }
            }

            else {

                // Continuation byte must be 10xxxxxx
                if ((num >> 6) != 0b10) {
                    return false;
                }

                bytesToCheck--;
            }
        }

        // All expected continuation bytes must be present
        return bytesToCheck == 0;
    }
}