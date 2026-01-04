public class ValidPalindromeString {
    public boolean isPalindrome(String s) {
        String cs = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // clean string
        int n = cs.length();

        if (cs.length() == 1)
            return true;

        for (int i = 0; i < n; i++) {
            if (cs.charAt(i) != cs.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
