public class ConvertNumtoHexadec {
    public String toHex(int num) {
        if (num == 0)
            return "0";

        // Handle negative numbers by converting to a long
        long longNum = num;
        if (longNum < 0) {
            longNum = (1L << 32) + longNum; // Converts to 32-bit unsigned value
        }

        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        String result = "";

        while (longNum > 0) {
            int remainder = (int) (longNum % 16); // Get the remainder (0 to 15)
            result = hexChars[remainder] + result; // Add to the front of the string
            longNum = longNum / 16; // Move to the next digit
        }

        return result;
    }
}