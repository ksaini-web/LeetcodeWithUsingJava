class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // [value, original index]
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort by value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[n];

        int start = 0;

        while (start < n) {
            int end = start;

            // Find one connected group
            while (end + 1 < n &&
                   pairs[end + 1][0] - pairs[end][0] <= limit) {
                end++;
            }

            // Original indices of this group
            int[] indices = new int[end - start + 1];

            for (int i = start; i <= end; i++) {
                indices[i - start] = pairs[i][1];
            }

            // Sort original positions
            Arrays.sort(indices);

            // Values are already sorted because pairs is sorted
            for (int i = 0; i < indices.length; i++) {
                ans[indices[i]] = pairs[start + i][0];
            }

            start = end + 1;
        }

        return ans;
    }
}
