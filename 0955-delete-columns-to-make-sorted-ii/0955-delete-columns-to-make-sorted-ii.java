class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        if (n <= 1) return 0;
        
        int deletions = 0;
        boolean[] sorted = new boolean[n - 1]; // track sorted pairs

        for (int col = 0; col < strs[0].length(); col++) {
            boolean deleteColumn = false;

            // Check if this column breaks any unsorted adjacent pair
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i]
                        && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    deletions++;
                    deleteColumn = true;
                    break;
                }
            }

            // If we delete this column, move to next
            if (deleteColumn) continue;

            // Otherwise, update sorted pairs
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i]
                        && strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }
        return deletions;
    }
}