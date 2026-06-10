import java.util.*;

class Solution {

    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] mx;
    int[][] mn;
    int[] lg;

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int k = lg[len];

        int maxVal = Math.max(mx[k][l], mx[k][r - (1 << k) + 1]);
        int minVal = Math.min(mn[k][l], mn[k][r - (1 << k) + 1]);

        return (long) maxVal - minVal;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int K = lg[n] + 1;

        mx = new int[K][n];
        mn = new int[K][n];

        for (int i = 0; i < n; i++) {
            mx[0][i] = nums[i];
            mn[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            int len = 1 << j;

            for (int i = 0; i + len <= n; i++) {
                mx[j][i] = Math.max(
                        mx[j - 1][i],
                        mx[j - 1][i + (len >> 1)]
                );

                mn[j][i] = Math.min(
                        mn[j - 1][i],
                        mn[j - 1][i + (len >> 1)]
                );
            }
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(
                        getValue(cur.l, nr),
                        cur.l,
                        nr
                ));
            }
        }

        return ans;
    }
}
