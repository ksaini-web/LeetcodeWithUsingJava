

class Solution {

    static class Node {
        long cnt;
        long sum;

        Node(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Node[][][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        digits = Long.toString(n).toCharArray();

        int len = digits.length;

        memo = new Node[len + 1][2][2][3][11][11];

        return dfs(0, 1, 0, 0, 10, 10).sum;
    }

    private Node dfs(int pos,
                     int tight,
                     int started,
                     int stateLen,
                     int a,
                     int b) {

        if (pos == digits.length) {
            return new Node(1, 0);
        }

        if (memo[pos][tight][started][stateLen][a][b] != null) {
            return memo[pos][tight][started][stateLen][a][b];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0) {

                if (d == 0) {
                    Node child = dfs(pos + 1, ntight, 0, 0, 10, 10);
                    totalCnt += child.cnt;
                    totalSum += child.sum;
                } else {
                    Node child = dfs(pos + 1, ntight, 1, 1, d, 10);
                    totalCnt += child.cnt;
                    totalSum += child.sum;
                }

            } else {

                if (stateLen == 1) {

                    Node child = dfs(pos + 1, ntight, 1, 2, a, d);

                    totalCnt += child.cnt;
                    totalSum += child.sum;

                } else {

                    int add = 0;

                    if ((b > a && b > d) || (b < a && b < d)) {
                        add = 1;
                    }

                    Node child = dfs(pos + 1, ntight, 1, 2, b, d);

                    totalCnt += child.cnt;
                    totalSum += child.sum + (long) add * child.cnt;
                }
            }
        }

        Node res = new Node(totalCnt, totalSum);

        if (tight == 0) {
            memo[pos][0][started][stateLen][a][b] = res;
        }

        return res;
    }
}
