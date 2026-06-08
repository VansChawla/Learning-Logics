public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i); //check for odd length palindromes
            count += countPalindromes(s, i, i + 1); //check for even length palindromes
        }

        return count;
    }

    private int countPalindromes(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
