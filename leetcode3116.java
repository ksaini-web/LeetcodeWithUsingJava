import java.util.*;

class Solution {
    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {
        // Sort and remove duplicates
        Arrays.sort(coins);

        List<Long> c = new ArrayList<>();

        for (int x : coins) {
            boolean redundant = false;

            // Remove denominations that are multiples
            // of a smaller denomination
            for (long y : c) {
                if (x % y == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                c.add((long) x);
            }
        }

        int n = c.size();

        // Count numbers <= x divisible by at least one coin
        // using inclusion-exclusion.
        java.util.function.LongFunction<Long> count = (x) -> {
            long ans = 0;

            for (int mask = 1; mask < (1 << n); mask++) {
                long curLcm = 1;
                int bits = 0;
                boolean tooLarge = false;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        bits++;

                        long coin = c.get(i);
                        long g = gcd(curLcm, coin);

                        // Avoid overflow:
                        // curLcm * (coin / g) <= x
                        if (curLcm > x / (coin / g)) {
                            tooLarge = true;
                            break;
                        }

                        curLcm = curLcm / g * coin;
                    }
                }

                if (tooLarge || curLcm > x) {
                    continue;
                }

                long ways = x / curLcm;

                if ((bits & 1) == 1) {
                    ans += ways;
                } else {
                    ans -= ways;
                }
            }

            return ans;
        };

        // Upper bound: k * smallest coin
        long lo = 1;
        long hi = c.get(0) * (long) k;

        // Binary search
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if (count.apply(mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
