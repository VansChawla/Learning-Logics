public class ReverseWordsinString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Convert String into Array

        StringBuilder reversedString = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            if (i > 0) {
                reversedString.append(" ");
            }
        }

        return reversedString.toString();
    }
}
