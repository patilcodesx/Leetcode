import java.util.*;

class Solution {

    static class State {
        int r, c, t, cost;
        State(int r, int c, int t, int cost) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE / 2;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        dist[0][0][0] = 0;
        pq.add(new State(0, 0, 0, 0));

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int r = cur.r, c = cur.c, t = cur.t, cost = cur.cost;

            if (cost > dist[r][c][t]) continue;

            if (r == m - 1 && c == n - 1)
                return cost;

            // Normal moves
            for (int d = 0; d < 2; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < m && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][t]) {
                        dist[nr][nc][t] = newCost;
                        pq.add(new State(nr, nc, t, newCost));
                    }
                }
            }

            // Teleport
            if (t < k) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] <= grid[r][c] && cost < dist[i][j][t + 1]) {
                            dist[i][j][t + 1] = cost;
                            pq.add(new State(i, j, t + 1, cost));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
