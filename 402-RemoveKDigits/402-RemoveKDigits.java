// Last updated: 9/23/2026, 2:44:30 PM
class Solution {
    public String removeKdigits(String num, int k) {

        // If we remove all digits
        if (k == num.length()) {
            return "0";
        }

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {

            // Remove larger digits from the left
            while (k > 0 &&
                   stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        // If k digits are still left, remove from the end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int start = 0;

        while (start < stack.length() &&
               stack.charAt(start) == '0') {
            start++;
        }

        if (start == stack.length()) {
            return "0";
        }

        return stack.substring(start);
    }
}