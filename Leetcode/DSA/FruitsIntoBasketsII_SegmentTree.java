public class FruitsIntoBasketsII_SegmentTree {
    private int[] tree;
    private int n;

    private void build(int[] baskets, int node, int start, int end) {
        if (start == end) {
            tree[node] = baskets[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(baskets, 2 * node + 1, start, mid);
        build(baskets, 2 * node + 2, mid + 1, end);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private int queryAndUpdate(int node, int start, int end, int fruitSize) {
        if (tree[node] < fruitSize) {
            return -1;
        }

        if (start == end) {
            int basketIndex = start;
            tree[node] = -1; 
            return basketIndex;
        }

        int mid = start + (end - start) / 2;
        int basketIndex = -1;

        if (tree[2 * node + 1] >= fruitSize) {
            basketIndex = queryAndUpdate(2 * node + 1, start, mid, fruitSize);
        } else {
            basketIndex = queryAndUpdate(2 * node + 2, mid + 1, end, fruitSize);
        }

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        
        return basketIndex;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.n = baskets.length;
        this.tree = new int[4 * n];

        build(baskets, 0, 0, n - 1);

        int unplacedCount = 0;

        for (int fruit : fruits) {
            int placedIndex = queryAndUpdate(0, 0, n - 1, fruit);
            
            if (placedIndex == -1) {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }
}