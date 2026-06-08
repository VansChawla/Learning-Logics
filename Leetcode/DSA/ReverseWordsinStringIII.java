class ReverseWordsinStringIII {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            String res = reverse(arr[i]);
            arr[i] = res;
        }

        return String.join(" ", arr);
    }
    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++; right--;
        }
        return new String(chars);
    }
}