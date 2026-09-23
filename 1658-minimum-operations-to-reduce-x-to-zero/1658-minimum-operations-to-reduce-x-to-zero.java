class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long target = totalSum - x;

        // If we need to keep nothing
        if (target == 0) {
            return n;
        }

        // Impossible
        if (target < 0) {
            return -1;
        }

        int left = 0;
        long sum = 0;
        int maxLen = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}