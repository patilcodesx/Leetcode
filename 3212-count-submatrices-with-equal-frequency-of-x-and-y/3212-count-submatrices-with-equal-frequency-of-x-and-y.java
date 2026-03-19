class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix = new int[m][n];
        int[][] countX = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = 0;
                if (grid[i][j] == 'X') val = 1;
                else if (grid[i][j] == 'Y') val = -1;

                prefix[i][j] = val;
                countX[i][j] = (grid[i][j] == 'X') ? 1 : 0;

                if (i > 0) {
                    prefix[i][j] += prefix[i - 1][j];
                    countX[i][j] += countX[i - 1][j];
                }
                if (j > 0) {
                    prefix[i][j] += prefix[i][j - 1];
                    countX[i][j] += countX[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                    countX[i][j] -= countX[i - 1][j - 1];
                }

                if (prefix[i][j] == 0 && countX[i][j] > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}