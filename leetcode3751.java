import java.util.*;

class Solution {

    static class Pair {
        long count;
        long waviness;

        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }

    private String s;
    private Pair[][][][][] dp;

    public int totalWaviness(int num1, int num2) {
        long ans = solve(num2) - solve((long) num1 - 1);
        return (int) ans;
    }

    private long solve(long x) {
        if (x < 0) return 0;

        s = String.valueOf(x);
        int n = s.length();

        dp = new Pair[n][11][11][2][2];

        return dfs(0, 10, 10, 0, 1).waviness;
    }

    private Pair dfs(int pos, int prev1, int prev2,
                     int started, int tight) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        if (dp[pos][prev1][prev2][started][tight] != null) {
            return dp[pos][prev1][prev2][started][tight];
        }

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight =
                    (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair child = dfs(
                        pos + 1,
                        10,
                        10,
                        0,
                        nextTight
                );

                totalCount += child.count;
                totalWaviness += child.waviness;

            } else {

                long add = 0;

                if (prev2 != 10) {
                    boolean peak =
                            prev2 < prev1 && prev1 > d;

                    boolean valley =
                            prev2 > prev1 && prev1 < d;

                    if (peak || valley) {
                        add = 1;
                    }
                }

                Pair child = dfs(
                        pos + 1,
                        d,
                        prev1,
                        1,
                        nextTight
                );

                totalCount += child.count;
                totalWaviness += child.waviness
                        + add * child.count;
            }
        }

        return dp[pos][prev1][prev2][started][tight] =
                new Pair(totalCount, totalWaviness);
    }
}
