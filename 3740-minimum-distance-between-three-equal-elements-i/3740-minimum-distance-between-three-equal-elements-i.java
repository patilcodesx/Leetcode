import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Collect indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Step 2: Process each value
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                // Sliding window of size 3
                for (int i = 0; i < indices.size() - 2; i++) {
                    int distance = 2 * (indices.get(i + 2) - indices.get(i));
                    ans = Math.min(ans, distance);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}