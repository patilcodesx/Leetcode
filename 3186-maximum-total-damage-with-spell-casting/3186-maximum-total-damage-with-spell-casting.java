import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        // Count frequency of each damage
        Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
        // Extract unique damage values and sort them
        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);

        int n = unique.size();
        // dp[i][0] = max damage using up to i-th unique, *not taking* unique[i]
        // dp[i][1] = max damage using up to i-th unique, *taking* unique[i]
        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            int val = unique.get(i);
            long totalDamage = (long) val * freq.get(val);

            // If we skip this value
            if (i > 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            }

            // If we take this value
            // We need to add totalDamage, plus the best we can get from earlier non-conflicting index
            dp[i][1] = totalDamage;

            // Find the largest index j < i such that unique[j] < val - 2
            int j = i - 1;
            while (j >= 0 && unique.get(j) >= val - 2) {
                j--;
            }
            if (j >= 0) {
                dp[i][1] += Math.max(dp[j][0], dp[j][1]);
            }
        }

        // The answer is the max between taking or skipping the last unique
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
