import java.util.Arrays;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (k >= sum) {
            return 0;
        }

        int left = 0, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long required = 0;

            for (int d : diff) {
                if (d > mid) {
                    required += d - mid;
                }
            }

            if (required <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long ans = 0;
        long used = 0;

        for (int d : diff) {
            if (d > left) {
                used += d - left;
                ans += (long) left * left;
            } else {
                ans += (long) d * d;
            }
        }

        long remaining = k - used;

        // Reduce the remaining differences by one where possible.
        for (int d : diff) {
            if (remaining == 0) {
                break;
            }

            if (d >= left && d > 0) {
                ans -= (long) left * left;
                ans += (long) (left - 1) * (left - 1);
                remaining--;
            }
        }

        return ans;
    }
}
