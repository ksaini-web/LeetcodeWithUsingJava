import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = -1, sc = -1;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        // Find starting position and assign IDs to litter.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        // visited[row][col][mask][remainingEnergy]
        boolean[][][][] visited = new boolean[
            m
        ][
            n
        ][
            1 << litterCount
        ][
            energy + 1
        ];

        // State = {row, col, mask, remainingEnergy, distance}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc, 0, energy, 0});
        visited[sr][sc][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int dist = cur[4];

            // All litter collected.
            if (mask == fullMask) {
                return dist;
            }

            // If energy is 0, we can only continue from R.
            if (e == 0 && classroom[r].charAt(c) != 'R') {
                continue;
            }

            // R resets energy.
            if (classroom[r].charAt(c) == 'R') {
                e = energy;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Can't move without energy.
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                char next = classroom[nr].charAt(nc);

                // Collect litter.
                if (next == 'L') {
                    int id = litterId[nr][nc];
                    newMask |= (1 << id);
                }

                // Entering R immediately restores energy.
                if (next == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newMask][newEnergy]) {
                    visited[nr][nc][newMask][newEnergy] = true;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newMask,
                        newEnergy,
                        dist + 1
                    });
                }
            }
        }

        return -1;
    }
}
