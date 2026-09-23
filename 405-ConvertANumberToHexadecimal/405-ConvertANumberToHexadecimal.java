// Last updated: 9/23/2026, 2:44:17 PM
class Solution {
    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        char[] hex = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f'
        };

        StringBuilder result = new StringBuilder();

        // Process 8 hexadecimal digits (32-bit integer)
        for (int i = 0; i < 8 && num != 0; i++) {

            int digit = num & 15;  // num & 0xF

            result.append(hex[digit]);

            num >>>= 4;
        }

        return result.reverse().toString();
    }
}