// Last updated: 9/23/2026, 2:46:30 PM
public class Solution {
    public NestedInteger deserialize(String s) {

        // If the string is just a number
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;

        int num = 0;
        int sign = 1;
        boolean hasNum = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                NestedInteger newList = new NestedInteger();

                if (current != null) {
                    stack.push(current);
                    current.add(newList);
                }

                current = newList;
            }

            else if (ch == '-') {
                sign = -1;
            }

            else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                hasNum = true;
            }

            else if (ch == ',' || ch == ']') {

                if (hasNum) {
                    current.add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                    hasNum = false;
                }

                if (ch == ']' && !stack.isEmpty()) {
                    current = stack.pop();
                }
            }
        }

        return current;
    }
}