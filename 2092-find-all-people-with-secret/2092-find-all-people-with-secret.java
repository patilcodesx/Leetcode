import java.util.*;

class Solution {

    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb)
                parent[pb] = pa;
        }

        void reset(int x) {
            parent[x] = x;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(n);
        dsu.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> temp = new ArrayList<>();

            // Collect all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                dsu.union(x, y);
                temp.add(new int[]{x, y});
                i++;
            }

            // Reset people not connected to 0
            for (int[] m : temp) {
                if (dsu.find(m[0]) != dsu.find(0)) {
                    dsu.reset(m[0]);
                    dsu.reset(m[1]);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (dsu.find(p) == dsu.find(0))
                result.add(p);
        }
        return result;
    }
}
