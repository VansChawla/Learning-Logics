import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    public int distSq(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distSq(b) - distSq(a));

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
            if (pq.size() > k)
                pq.poll();
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();

        return res;
    }
}
