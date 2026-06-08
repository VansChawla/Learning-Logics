import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the recursion with an empty string and 0 brackets used
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String currentString, int openCount, int closeCount, int max) {
        // Base Case: If the string length is exactly 2 * n, we have a complete valid combination
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }

        // Rule 1: We can add an open parenthesis if we haven't reached 'max'
        if (openCount < max) {
            backtrack(result, currentString + "(", openCount + 1, closeCount, max);
        }

        // Rule 2: We can add a close parenthesis if it has a matching open parenthesis
        if (closeCount < openCount) {
            backtrack(result, currentString + ")", openCount, closeCount + 1, max);
        }
    }
}