import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        // If array has only one element
        if (n == 1)
            return 0;

        // Map value -> all indices having that value
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();

        // Start from index 0
        queue.offer(0);

        // Visited array
        boolean[] visited = new boolean[n];
        visited[0] = true;

        int steps = 0;

        // BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int s = 0; s < size; s++) {

                int current = queue.poll();

                // Reached last index
                if (current == n - 1)
                    return steps;

                // -------------------
                // 1. Jump to i - 1
                // -------------------
                int left = current - 1;

                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    queue.offer(left);
                }

                // -------------------
                // 2. Jump to i + 1
                // -------------------
                int right = current + 1;

                if (right < n && !visited[right]) {
                    visited[right] = true;
                    queue.offer(right);
                }

                // -------------------
                // 3. Jump to same values
                // -------------------
                List<Integer> sameValueIndices = map.get(arr[current]);

                for (int idx : sameValueIndices) {

                    if (!visited[idx]) {
                        visited[idx] = true;
                        queue.offer(idx);
                    }
                }

                // IMPORTANT OPTIMIZATION
                // Clear list after use
                map.get(arr[current]).clear();
            }

            // One level completed
            steps++;
        }

        return -1;
    }
}
