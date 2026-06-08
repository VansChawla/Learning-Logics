import java.util.PriorityQueue;

public class KWeakestRowsinMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = countSoldiers(mat[i]);
            pq.add(new Row(count, i));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().idx;
        }

        return res;
    }

    private int countSoldiers(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
    }
}
