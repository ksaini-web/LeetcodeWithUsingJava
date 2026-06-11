class Solution {
    static final long MOD = 1_000_000_007L;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(1, 0, 0, g);

        return (int) power(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int depth, List<Integer>[] g) {
        maxDepth = Math.max(maxDepth, depth);

        for (int next : g[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1, g);
            }
        }
    }

    private long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }
}
