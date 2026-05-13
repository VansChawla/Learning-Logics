public class MagicalString {
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1;

        StringBuilder s = new StringBuilder("122");
        int head = 2;

        while (s.length() < n) {
            int count = s.charAt(head) - '0';

            char nextChar = (s.charAt(s.length() - 1) == '1') ? '2' : '1';

            for (int i = 0; i < count; i++) {
                s.append(nextChar);
            }

            head++;
        }

        int onesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            }
        }

        return onesCount;
    }
}
