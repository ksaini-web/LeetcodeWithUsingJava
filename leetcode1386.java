class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int ans = (n - map.size()) * 2;

        for (int row : map.keySet()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            HashSet<Integer> seats = map.get(row);

            // 2,3,4,5
            for (int col = 2; col <= 5; col++) {
                if (seats.contains(col)) {
                    left = false;
                }
            }

            // 4,5,6,7
            for (int col = 4; col <= 7; col++) {
                if (seats.contains(col)) {
                    middle = false;
                }
            }

            // 6,7,8,9
            for (int col = 6; col <= 9; col++) {
                if (seats.contains(col)) {
                    right = false;
                }
            }

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}
