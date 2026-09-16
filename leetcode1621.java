class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;

        int[][] f = new int[n + 1][k + 1];
        int[][] g = new int[n + 1][k + 1];

        // No segment, first point processed
        f[1][0] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // Don't start/continue a segment here
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;

                // Continue an already active segment
                g[i][j] = g[i - 1][j];

                if (j > 0) {

                    // Start a new segment from a free state
                    g[i][j] += f[i - 1][j - 1];
                    g[i][j] %= MOD;

                    // Start/continue after an existing segment
                    g[i][j] += g[i - 1][j - 1];
                    g[i][j] %= MOD;
                }
            }
        }

        return (f[n][k] + g[n][k]) % MOD;
    }
}
