import java.util.HashMap;
import java.util.Map;

class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        
        // Count of values on the left of current position
        Map<Integer, Integer> leftCounts = new HashMap<>();
        // Count of values on the right of current position
        Map<Integer, Integer> rightCounts = new HashMap<>();
        
        // Initialize rightCounts with all elements
        for (int num : nums) {
            rightCounts.merge(num, 1, Integer::sum);
        }
        
        long total = 0L;
        
        // Iterate, treating each element as the middle of a potential triplet
        for (int x : nums) {
            // Move x from right side to current position
            rightCounts.merge(x, -1, Integer::sum);
            
            int target = x * 2;  // we want (2x, x, 2x)
            
            long left = leftCounts.getOrDefault(target, 0);
            long right = rightCounts.getOrDefault(target, 0);
            
            total = (total + (left * right) % MOD) % MOD;
            
            // Now x becomes part of the left side for future middles
            leftCounts.merge(x, 1, Integer::sum);
        }
        
        return (int) total;
    }
}
