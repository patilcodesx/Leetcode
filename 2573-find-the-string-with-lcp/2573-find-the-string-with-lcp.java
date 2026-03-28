class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        // Step 1: Validate diagonal
        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
        }

        // Step 2: Union Find
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] > 0) {
                    union(parent, i, j);
                }
            }
        }

        // Step 3: Assign characters
        char[] res = new char[n];
        char ch = 'a';
        int[] map = new int[n];
        Arrays.fill(map, -1);

        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            if (map[p] == -1) {
                if (ch > 'z') return ""; // too many groups
                map[p] = ch++;
            }
            res[i] = (char) map[p];
        }

        // Step 4: Validate LCP
        int[][] check = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j]) {
                    check[i][j] = 1 + ((i + 1 < n && j + 1 < n) ? check[i + 1][j + 1] : 0);
                } else {
                    check[i][j] = 0;
                }
                if (check[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);
        if (pa != pb) parent[pa] = pb;
    }
}