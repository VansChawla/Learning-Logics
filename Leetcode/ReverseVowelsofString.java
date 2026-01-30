public class ReverseVowelsofString {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int st = 0;
        int ed = arr.length - 1;

        while (st < ed) {
            if (st < ed && !isVowel(arr[st])) {
                st++;
                continue;
            }

            if (st < ed && !isVowel(arr[ed])) {
                ed--;
                continue;
            }

            char temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;
            ed--;
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

}
