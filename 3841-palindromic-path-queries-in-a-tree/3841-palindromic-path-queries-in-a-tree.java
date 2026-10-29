import java.util.*;

class Solution {
    List<Integer>[] g;
    int[][] up;
    int[] tin, tout, depth, bit;
    int timer, LOG;
    char[] s;

    public List<Boolean> palindromePath(int n, int[][] edges, String str, String[] queries) {
        s = str.toCharArray();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        up = new int[n][LOG];
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        bit = new int[n + 2];

        dfs(0, 0);

        for (int j = 1; j < LOG; j++)
            for (int i = 0; i < n; i++)
                up[i][j] = up[up[i][j - 1]][j - 1];

        for (int i = 0; i < n; i++)
            range(tin[i], tout[i], 1 << (s[i] - 'a'));

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] a = q.split(" ");
            int u = Integer.parseInt(a[1]);

            if (a[0].equals("update")) {
                int diff = (1 << (s[u] - 'a')) ^ (1 << (a[2].charAt(0) - 'a'));
                range(tin[u], tout[u], diff);
                s[u] = a[2].charAt(0);
            } else {
                int v = Integer.parseInt(a[2]), l = lca(u, v);
                int mask = prefix(tin[u]) ^ prefix(tin[v])
                         ^ (1 << (s[l] - 'a'));
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    void dfs(int u, int p) {
        tin[u] = ++timer;
        up[u][0] = p;
        for (int v : g[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u);
        }
        tout[u] = timer;
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u; u = v; v = t;
        }
        int d = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++)
            if ((d & (1 << j)) != 0) u = up[u][j];
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--)
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        return up[u][0];
    }

    void range(int l, int r, int x) {
        add(l, x);
        add(r + 1, x);
    }

    void add(int i, int x) {
        for (; i < bit.length; i += i & -i) bit[i] ^= x;
    }

    int prefix(int i) {
        int x = 0;
        for (; i > 0; i -= i & -i) x ^= bit[i];
        return x;
    }
}