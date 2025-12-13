public class LengthofLastString {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;

        // Step 1: Skip the trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count the actual characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}
