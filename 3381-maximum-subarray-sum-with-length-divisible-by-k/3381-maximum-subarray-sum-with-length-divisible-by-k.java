class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        // set to large positive values
        Arrays.fill(minPrefix, Long.MAX_VALUE / 4);
        // prefix sum for index -1 (empty prefix) should map to remainder (k-1)
        minPrefix[(k - 1) % k] = 0L;

        long prefix = 0L;
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            prefix += nums[i];
            int r = i % k;
            // candidate subarray sum ending at i with length divisible by k:
            ans = Math.max(ans, prefix - minPrefix[r]);
            // update minimum prefix for this remainder
            if (prefix < minPrefix[r]) minPrefix[r] = prefix;
        }

        return ans;
    }
}
