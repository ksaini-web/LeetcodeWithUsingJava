
class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count how many times each digit appears
        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        // Check every 3-digit even number
        for (int num = 100; num <= 998; num += 2) {

            int n = num;

            int a = n / 100;          // hundreds digit
            int b = (n / 10) % 10;    // tens digit
            int c = n % 10;           // ones digit

            // Use a temporary frequency array
            int[] need = new int[10];

            need[a]++;
            need[b]++;
            need[c]++;

            boolean possible = true;

            for (int i = 0; i <= 9; i++) {
                if (need[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans++;
            }
        }

        return ans;
    }
}

