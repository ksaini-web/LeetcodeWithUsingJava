
class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] result = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            // Start a new subarray with only current element
            int single = num % k;
            newDp[single]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {
                    int newRemainder = (r * single) % k;

                    newDp[newRemainder] += dp[r];
                }
            }

            // All subarrays ending at current index
            // contribute to the final answer
            for (int r = 0; r < k; r++) {
                result[r] += newDp[r];
            }

            dp = newDp;
        }

        return result;
    }
}
