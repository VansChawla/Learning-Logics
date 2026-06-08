public class CountDigits {
    public int countDigits(int num) {
        int temp = num;
        int count = 0;
        while (num > 0) {
            int n = num % 10;
            if (temp % n == 0) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }
}
