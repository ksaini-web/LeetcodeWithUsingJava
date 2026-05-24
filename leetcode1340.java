import java.util.*;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }

        return ans;
    }

    private int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != -1) return dp[i];

        int n = arr.length;
        int max = 1; // at least the current index

        // move left
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) break; // blocked
            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        // move right
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[j] >= arr[i]) break; // blocked
            max = Math.max(max, 1 + dfs(j, arr, d, dp));
        }

        return dp[i] = max;
    }
}
