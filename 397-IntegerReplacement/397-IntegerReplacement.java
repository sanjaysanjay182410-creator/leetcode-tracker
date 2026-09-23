// Last updated: 9/23/2026, 2:44:51 PM
class Solution {
    public int integerReplacement(int n) {

        long num = n;
        int count = 0;

        while (num != 1) {

            if (num % 2 == 0) {
                // Even number
                num /= 2;
            } 
            else {
                // Odd number
                if (num == 3 || num % 4 == 1) {
                    num--;
                } 
                else {
                    num++;
                }
            }

            count++;
        }

        return count;
    }
}