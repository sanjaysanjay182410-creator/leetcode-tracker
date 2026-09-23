// Last updated: 9/23/2026, 2:45:00 PM
import java.util.*;

class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int number = 0;

        for (char ch : s.toCharArray()) {

            // Build the number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Start a new encoded string
            else if (ch == '[') {
                countStack.push(number);
                stringStack.push(current);

                number = 0;
                current = "";
            }

            // Decode the current string
            else if (ch == ']') {
                int repeat = countStack.pop();
                String previous = stringStack.pop();

                StringBuilder temp = new StringBuilder(previous);

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }

                current = temp.toString();
            }

            // Normal character
            else {
                current += ch;
            }
        }

        return current;
    }
}