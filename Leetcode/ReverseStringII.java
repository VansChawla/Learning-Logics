public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
      
        for (int startIndex = 0; startIndex < length; startIndex += k * 2) {
            int left = startIndex;
            int right = Math.min(startIndex + k - 1, length - 1);
          
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
              
                left++;
                right--;
            }
        }
      
        return new String(charArray);
    }
}