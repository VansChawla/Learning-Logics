public class BasicCalculator {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (s.charAt(i) - '0');
            } else if (c == '+') {
                result += (number * sign);
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += (number * sign);
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                result += (number * sign); // Inside bracket result
                number = 0;

                int stack_sign = stack.peek();
                stack.pop();
                int last_result = stack.peek();
                stack.pop();

                result *= stack_sign;
                result += last_result;
            }
        }

        result += (number * sign);
        return result;
    }
}
