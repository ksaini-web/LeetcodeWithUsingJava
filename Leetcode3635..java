import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        RideHelper waterHelper = new RideHelper(waterStartTime, waterDuration);
        RideHelper landHelper = new RideHelper(landStartTime, landDuration);

        long ans = Long.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {
            long landFinish = (long) landStartTime[i] + landDuration[i];
            ans = Math.min(ans, waterHelper.query(landFinish));
        }

        // Water -> Land
        for (int i = 0; i < waterStartTime.length; i++) {
            long waterFinish = (long) waterStartTime[i] + waterDuration[i];
            ans = Math.min(ans, landHelper.query(waterFinish));
        }

        return (int) ans;
    }

    static class RideHelper {
        int[] start;
        long[] prefMinDur;
        long[] suffMinFinish;
        int n;

        RideHelper(int[] startTime, int[] duration) {
            n = startTime.length;

            int[][] rides = new int[n][2];
            for (int i = 0; i < n; i++) {
                rides[i][0] = startTime[i];
                rides[i][1] = duration[i];
            }

            Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

            start = new int[n];
            prefMinDur = new long[n];
            suffMinFinish = new long[n + 1];

            for (int i = 0; i < n; i++) {
                start[i] = rides[i][0];
            }

            prefMinDur[0] = rides[0][1];
            for (int i = 1; i < n; i++) {
                prefMinDur[i] = Math.min(prefMinDur[i - 1], rides[i][1]);
            }

            suffMinFinish[n] = Long.MAX_VALUE;
            for (int i = n - 1; i >= 0; i--) {
                long finish = (long) rides[i][0] + rides[i][1];
                suffMinFinish[i] = Math.min(suffMinFinish[i + 1], finish);
            }
        }

        long query(long x) {
            int idx = upperBound(start, x);

            long res = Long.MAX_VALUE;

            // rides already open
            if (idx > 0) {
                res = Math.min(res, x + prefMinDur[idx - 1]);
            }

            // rides not yet open
            res = Math.min(res, suffMinFinish[idx]);

            return res;
        }

        private int upperBound(int[] arr, long target) {
            int left = 0, right = arr.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
