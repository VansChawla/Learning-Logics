import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        Stack<Integer> extraOpenBrackets = new Stack<>();
        Stack<Integer> aestrick = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                extraOpenBrackets.push(i);
            } else if (ch == '*') {
                aestrick.push(i);
            } else {
                // Closing
                if (!extraOpenBrackets.isEmpty()) {
                    extraOpenBrackets.pop();
                } else if (!aestrick.isEmpty()) {
                    aestrick.pop();
                } else {
                    return false;
                }
            }
        }

        while (!extraOpenBrackets.isEmpty()) {
            if (aestrick.isEmpty()) {
                return false;
            }
            if (extraOpenBrackets.pop() > aestrick.pop()) {
                return false;
            }
        }

        return extraOpenBrackets.isEmpty();
    }
}
