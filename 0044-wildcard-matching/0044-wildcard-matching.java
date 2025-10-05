class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        

        // Empty string and empty pattern match 
        dp[0][0] = true;

        // Handle patterns like *, **, *** for empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == s.charAt(i - 1) || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "a"));   // false
        System.out.println(sol.isMatch("aa", "*"));   // true
        System.out.println(sol.isMatch("cb", "?a"));  // false
    }
}
