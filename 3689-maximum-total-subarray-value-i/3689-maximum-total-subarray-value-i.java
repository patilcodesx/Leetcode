class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long mx = 0;
        long mn = Long.MAX_VALUE;

        for (int x : nums) {
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }

        return (mx - mn) * (long) k;
    }
}