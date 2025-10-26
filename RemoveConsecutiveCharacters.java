public class RemoveConsecutiveCharacters {
    public String removeConsecutiveCharacter(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1))
                continue;
            else
                result.append(s.charAt(i));
        }

        return result.toString();
    }
}
