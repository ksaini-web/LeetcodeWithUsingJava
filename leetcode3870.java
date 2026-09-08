class Solution {
    public int countCommas(int n) {
        int ans = 0;
        long start = 1000;
        int commas = 1;

        while (start <= n) {
            long end = start * 1000 - 1;

            long count = Math.min((long) n, end) - start + 1;

            ans += count * commas;

            start *= 1000;
            commas++;
        }

        return ans;
    }
}
