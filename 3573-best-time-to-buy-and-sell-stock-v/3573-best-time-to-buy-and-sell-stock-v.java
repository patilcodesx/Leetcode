class Solution {
    public long maximumProfit(int[] prices, int k) {
        long NEG = Long.MIN_VALUE / 4;

        long[][] dp = new long[k + 1][3];

        // Initialize
        for (int t = 0; t <= k; t++) {
            dp[t][0] = NEG;
            dp[t][1] = NEG;
            dp[t][2] = NEG;
        }
        dp[0][0] = 0;

        for (int price : prices) {
            long[][] next = new long[k + 1][3];

            for (int t = 0; t <= k; t++) {
                for (int s = 0; s < 3; s++) {
                    next[t][s] = dp[t][s];
                }
            }

            for (int t = 0; t <= k; t++) {
                // Neutral → open long / short
                if (dp[t][0] != NEG) {
                    next[t][1] = Math.max(next[t][1], dp[t][0] - price); // buy
                    next[t][2] = Math.max(next[t][2], dp[t][0] + price); // sell short
                }

                // Close long
                if (dp[t][1] != NEG && t + 1 <= k) {
                    next[t + 1][0] = Math.max(next[t + 1][0], dp[t][1] + price);
                }

                // Close short
                if (dp[t][2] != NEG && t + 1 <= k) {
                    next[t + 1][0] = Math.max(next[t + 1][0], dp[t][2] - price);
                }
            }

            dp = next;
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[t][0]);
        }
        return ans;
    }
}
