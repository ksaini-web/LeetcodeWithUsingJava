class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // pal[i][j] = true if s[i...j] is palindrome
        boolean[][] pal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 1 || pal[i + 1][j - 1])) {

                    pal[i][j] = true;
                }
            }
        }

        // dp[i] = maximum palindromes using first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Don't choose a palindrome ending at i-1
            dp[i] = dp[i - 1];

            // Palindrome of length k
            if (i >= k) {
                int start = i - k;

                if (pal[start][i - 1]) {
                    dp[i] = Math.max(dp[i],
                                     dp[start] + 1);
                }
            }

            // Palindrome of length k + 1
            if (i >= k + 1) {
                int start = i - k - 1;

                if (pal[start][i - 1]) {
                    dp[i] = Math.max(dp[i],
                                     dp[start] + 1);
                }
            }
        }

        return dp[n];
    }
}
