import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombsofPhoneNo {
    private static final String[] KEYPAD = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, String currentCombination, int index) {
        if (index == digits.length()) {
            result.add(currentCombination);
            return;
        }

        // 1. Get the current digit we are working on (e.g., '2')
        char digitChar = digits.charAt(index);

        // 2. Convert char '2' to integer 2 to use as array index
        int digit = digitChar - '0';

        // 3. Get the letters for this digit (e.g., "abc")
        String letters = KEYPAD[digit];

        // 4. Loop through these letters and recurse
        for (char letter : letters.toCharArray()) {
            // Add the letter and move to the next index
            backtrack(result, digits, currentCombination + letter, index + 1);
        }
    }
}
