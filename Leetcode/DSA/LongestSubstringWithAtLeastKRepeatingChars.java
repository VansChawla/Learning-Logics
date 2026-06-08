import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int maxLen = 0;
        int n = s.length();

        for (int currUniqueTarget = 1; currUniqueTarget <= 26; currUniqueTarget++) {
            Arrays.fill(counts, 0);
            int left = 0, right = 0;
            int uniqueInWindow = 0;
            int countAtLeastK = 0;

            while (right < n) {
                // Expand window
                int addIdx = str[right] - 'a';
                if (counts[addIdx] == 0)
                    uniqueInWindow++;
                counts[addIdx]++;
                if (counts[addIdx] == k)
                    countAtLeastK++;
                right++;

                // Shrink window if we exceed the unique character target
                while (uniqueInWindow > currUniqueTarget) {
                    int removeIdx = str[left] - 'a';
                    if (counts[removeIdx] == k)
                        countAtLeastK--;
                    counts[removeIdx]--;
                    if (counts[removeIdx] == 0)
                        uniqueInWindow--;
                    left++;
                }

                if (uniqueInWindow == currUniqueTarget && uniqueInWindow == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}
