public class DivAndNondivSumDiff {
    public int differenceOfSums(int n, int m) {
        int nonDiv = 0;
        int div = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0)
                nonDiv += i;
            else
                div += i;
        }

        return nonDiv - div;
    }
}
