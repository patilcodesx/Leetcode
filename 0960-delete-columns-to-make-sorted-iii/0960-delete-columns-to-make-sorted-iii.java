class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        int maxKeep = 1;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < j; i++) {
                if (isValid(strs, i, j)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[j]);
        }

        return cols - maxKeep;
    }

    private boolean isValid(String[] strs, int i, int j) {
        for (String s : strs) {
            if (s.charAt(i) > s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
