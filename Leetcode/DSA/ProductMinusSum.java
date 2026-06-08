public class ProductMinusSum {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int pro = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            pro *= num;
            n = n / 10;
        }

        return pro - sum;
    }
}
