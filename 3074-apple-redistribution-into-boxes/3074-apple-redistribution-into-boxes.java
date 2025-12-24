import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Step 1: Total apples
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Step 2: Sort capacities in descending order
        Arrays.sort(capacity);
        
        int boxesUsed = 0;

        // Step 3: Use largest boxes first
        for (int i = capacity.length - 1; i >= 0 && totalApples > 0; i--) {
            totalApples -= capacity[i];
            boxesUsed++;
        }

        return boxesUsed;
    }
}
