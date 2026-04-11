import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Store indices for each value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Step 2: Process each value's indices
        for (List<Integer> indices : map.values()) {
            if (indices.size() < 3) continue;
            
            // Step 3: Check consecutive triplets
            for (int i = 0; i + 2 < indices.size(); i++) {
                int dist = 2 * (indices.get(i + 2) - indices.get(i));
                minDistance = Math.min(minDistance, dist);
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}