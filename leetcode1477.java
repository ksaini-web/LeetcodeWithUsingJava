class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int INF = n + 1;

        // best[i] = minimum length of a target-sum subarray
        // completely inside arr[0...i]
        int[] best = new int[n];

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int ans = INF;

        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Make sum <= target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Found a subarray [left...right]
            if (sum == target) {

                int len = right - left + 1;

                // Check if there was a previous
                // non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Store minimum length ending at/before right
                if (right == 0) {
                    best[right] = len;
                } else {
                    best[right] = Math.min(best[right - 1], len);
                }

            } else {
                // No target subarray ending at right
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return ans == INF ? -1 : ans;
    }
}
