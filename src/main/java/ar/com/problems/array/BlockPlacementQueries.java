package ar.com.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.
 *
 * You are given a 2D array queries, which contains two types of queries:
 *
 * 1. For a query of type 1, queries[i] = [1, x]. Build an obstacle at distance x from the origin.
 * It is guaranteed that there is no obstacle at distance x when the query is asked.
 *
 * 2. For a query of type 2, queries[i] = [2, x, sz]. Check if it is possible to place a block of size sz anywhere
 * in the range [0, x] on the line, such that the block entirely lies in the range [0, x]. A block cannot be
 * placed if it intersects with any obstacle, but it may touch it. Note that you do not actually place the block.
 * Queries are separate.
 * Return a boolean array results, where results[i] is true if you can place the block specified in the ith query
 * of type 2, and false otherwise.
 *
 *
 * Constraints:
 *
 * 1 <= queries.length <= 15 * 104
 * 2 <= queries[i].length <= 3
 * 1 <= queries[i][0] <= 2
 * 1 <= x, sz <= min(5 * 104, 3 * queries.length)
 * The input is generated such that for queries of type 1, no obstacle exists at distance x when the query is asked.
 * The input is generated such that there is at least one query of type 2.
 *
 */
public class BlockPlacementQueries {

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }
        var st = new SegTree(maxX + 1);
        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                st.update(q[1]);
            } else {
                int[] node = st.query(0, q[1]);
                int maxSize;
                if (node[0] == -1) {
                    maxSize = q[1];
                } else {
                    maxSize = Math.max(node[0], node[2]);
                    maxSize = Math.max(maxSize, q[1] - node[1]);
                }
                result.add(maxSize >= q[2]);
            }
        }
        return result;
    }

    static class SegTree {
        int n;
        int[] firstObs, lastObs, maxGap;

        SegTree(int n) {
            this.n = n;
            int size = 4 * n;
            firstObs = new int[size];
            lastObs = new int[size];
            maxGap = new int[size];
            if (n > 0) build(1, 0, n - 1);
        }

        void build(int idx, int l, int r) {
            firstObs[idx] = -1;
            lastObs[idx] = -1;
            maxGap[idx] = 0;
            if (l == r) return;
            int m = (l + r) / 2;
            build(idx * 2, l, m);
            build(idx * 2 + 1, m + 1, r);
        }

        void update(int pos) {
            update(1, 0, n - 1, pos);
        }

        void update(int idx, int l, int r, int pos) {
            if (l == r) {
                firstObs[idx] = lastObs[idx] = pos;
                maxGap[idx] = 0;
                return;
            }
            int m = (l + r) / 2;
            if (pos <= m) update(idx * 2, l, m, pos);
            else update(idx * 2 + 1, m + 1, r, pos);
            pull(idx);
        }

        void pull(int idx) {
            int li = idx * 2, ri = idx * 2 + 1;
            if (firstObs[li] == -1 && firstObs[ri] == -1) {
                firstObs[idx] = lastObs[idx] = -1;
                maxGap[idx] = 0;
            } else if (firstObs[li] == -1) {
                firstObs[idx] = firstObs[ri];
                lastObs[idx] = lastObs[ri];
                maxGap[idx] = maxGap[ri];
            } else if (firstObs[ri] == -1) {
                firstObs[idx] = firstObs[li];
                lastObs[idx] = lastObs[li];
                maxGap[idx] = maxGap[li];
            } else {
                firstObs[idx] = firstObs[li];
                lastObs[idx] = lastObs[ri];
                maxGap[idx] = Math.max(maxGap[li], maxGap[ri]);
                maxGap[idx] = Math.max(maxGap[idx], firstObs[ri] - lastObs[li]);
            }
        }

        int[] query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        int[] query(int idx, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return new int[]{firstObs[idx], lastObs[idx], maxGap[idx]};
            }
            int m = (l + r) / 2;
            if (qr <= m) return query(idx * 2, l, m, ql, qr);
            if (ql > m) return query(idx * 2 + 1, m + 1, r, ql, qr);
            return merge(query(idx * 2, l, m, ql, qr), query(idx * 2 + 1, m + 1, r, ql, qr));
        }

        int[] merge(int[] a, int[] b) {
            if (a[0] == -1 && b[0] == -1) return new int[]{-1, -1, 0};
            if (a[0] == -1) return b;
            if (b[0] == -1) return a;
            int max = Math.max(a[2], b[2]);
            max = Math.max(max, b[0] - a[1]);
            return new int[]{a[0], b[1], max};
        }
    }
}
