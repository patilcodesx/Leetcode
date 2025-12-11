class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // n is grid size (1..n). buildings contains unique coordinates [x,y].
        // We'll use 1-based indexing arrays of size n+1.
        int[] minYInRow = new int[n+1];
        int[] maxYInRow = new int[n+1];
        int[] minXInCol = new int[n+1];
        int[] maxXInCol = new int[n+1];

        // Initialize extremes
        for (int i = 1; i <= n; i++) {
            minYInRow[i] = Integer.MAX_VALUE;
            maxYInRow[i] = Integer.MIN_VALUE;
            minXInCol[i] = Integer.MAX_VALUE;
            maxXInCol[i] = Integer.MIN_VALUE;
        }

        // First pass: compute min/max for each row and column
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            if (y < minYInRow[x]) minYInRow[x] = y;
            if (y > maxYInRow[x]) maxYInRow[x] = y;
            if (x < minXInCol[y]) minXInCol[y] = x;
            if (x > maxXInCol[y]) maxXInCol[y] = x;
        }

        // Second pass: count buildings that are strictly between min and max in both row and column
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            boolean hasLeftAndRight = (minYInRow[x] < y && y < maxYInRow[x]);
            boolean hasUpAndDown    = (minXInCol[y] < x && x < maxXInCol[y]);
            if (hasLeftAndRight && hasUpAndDown) count++;
        }

        return count;
    }
}
