class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        boolean[] dp = new boolean[n];
        
        dp[0] = true;
        
        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // add new reachable index into window
            if (i >= minJump && dp[i - minJump]) {
                reachable++;
            }

            // remove old index from window
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachable--;
            }

            // current index reachable?
            if (reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}
