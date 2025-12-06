import java.util.Stack;

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // Use a stack to store the numbers (operands)
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if the current token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop the top two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Perform the operation and push the result back onto the stack
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            } else {
                // If the token is a number, convert it to an integer and push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only remaining element on the stack
        return stack.pop();
    }
}
