class Solution {
    public int numberOfSets(int n, int k) {
        final long MOD = 1_000_000_007L;

        // dp[j] = number of ways to form j segments
        // after processing the current number of points
        long[] dp = new long[k + 1];

        // open[j] = number of ways where the j-th segment
        // is currently open
        long[] open = new long[k + 1];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            // Process from high to low so previous values
            // are not overwritten too early.
            for (int j = Math.min(k, i); j >= 1; j--) {

                /*
                 * Start a new segment at point i-1
                 * or extend an already open segment.
                 */
                open[j] = (open[j] + dp[j - 1]) % MOD;

                /*
                 * We can either:
                 * 1. keep the existing j segments
                 * 2. close the currently open j-th segment
                 */
                dp[j] = (dp[j] + open[j]) % MOD;
            }
        }

        return (int) dp[k];
    }
}