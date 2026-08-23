class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int diff = 0;
        int qDiff = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                qDiff++;
            } else {
                diff += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                qDiff--;
            } else {
                diff -= c - '0';
            }
        }

        // Multiply by 2 to avoid floating-point / integer-division issues.
        return 2 * diff != -9 * qDiff;
    }
}
