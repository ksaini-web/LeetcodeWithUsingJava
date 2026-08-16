class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];

        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        // No stones with remainder 1 or 2
        if (cnt[1] == 0 && cnt[2] == 0) {
            return false;
        }

        // If the number of remainder-0 stones is even,
        // Alice wins when one of cnt[1], cnt[2] is at least 1
        // and the other is at least 3.
        if (cnt[0] % 2 == 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }

        // If cnt[0] is odd, Alice needs one side to have
        // at least 3 more stones than the other.
        return Math.abs(cnt[1] - cnt[2]) > 2;
    }
}
