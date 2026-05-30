

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            idx++;
            while (idx < bit.length) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            idx++;
            int res = 0;
            while (idx > 0) {
                res = Math.max(res, bit[idx]);
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
            if (q[0] == 1) {
                set.add(q[1]);
            }
        }

        Fenwick fenwick = new Fenwick(maxX + 2);

        int prev = 0;
        for (int pos : set) {
            if (pos == 0) continue;
            fenwick.update(pos, pos - prev);
            prev = pos;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                int p = set.floor(x);
                int tailGap = x - p;

                int maxGap = Math.max(fenwick.query(x), tailGap);
                ans.add(maxGap >= sz);
            } else {
                int x = q[1];

                Integer left = set.lower(x);
                Integer right = set.higher(x);

                if (right != null) {
                    fenwick.update(right, right - left);
                }

                set.remove(x);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
