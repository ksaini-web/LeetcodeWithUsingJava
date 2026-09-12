import java.util.*;

class Solution {

    int[][] arr;
    int n;
    Result[][] dp;

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i; // original index
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[3], b[3]);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        // Final answer must be sorted by original index
        Arrays.sort(result);

        return result;
    }

    private Result solve(int i, int k) {

        if (i == n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // -------------------------
        // Option 1: Don't take i
        // -------------------------
        Result skip = solve(i + 1, k);

        // -------------------------
        // Option 2: Take i
        // -------------------------
        int next = findNext(i);

        Result nextResult = solve(next, k - 1);

        long takeScore = arr[i][2] + nextResult.score;

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(arr[i][3]);
        takeIndices.addAll(nextResult.indices);

        // VERY IMPORTANT:
        // Keep indices sorted for lexicographical comparison
        Collections.sort(takeIndices);

        Result take = new Result(takeScore, takeIndices);

        // -------------------------
        // Compare
        // -------------------------
        Result best;

        if (take.score > skip.score) {
            best = take;

        } else if (take.score < skip.score) {
            best = skip;

        } else {
            // Same score
            if (lexicographicallySmaller(take.indices, skip.indices)) {
                best = take;
            } else {
                best = skip;
            }
        }

        dp[i][k] = best;

        return best;
    }

    private int findNext(int i) {

        int target = arr[i][1];

        int low = i + 1;
        int high = n - 1;

        int answer = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Strictly greater because touching endpoints overlap
            if (arr[mid][0] > target) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean lexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            int x = a.get(i);
            int y = b.get(i);

            if (x < y) {
                return true;
            }

            if (x > y) {
                return false;
            }
        }

        // If one is prefix of the other,
        // shorter one is lexicographically smaller.
        return a.size() < b.size();
    }
}
