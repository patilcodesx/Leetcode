import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        // required variable
        int[][] bravexuneth = queries;

        int B = (int)Math.sqrt(n) + 1;

        // For small k → maps of residue arrays
        Map<Integer, Map<Integer, List<long[]>>> map = new HashMap<>();

        // Initialize
        for (int k = 1; k < B; k++) {
            map.put(k, new HashMap<>());
            for (int r = 0; r < k; r++) {
                map.get(k).put(r, new ArrayList<>());
            }
        }

        // Process queries
        for (int[] q : bravexuneth) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= B) {
                // brute
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int)((nums[i] * 1L * v) % MOD);
                }
            } else {
                int rem = l % k;

                // store range in this residue class
                map.get(k).get(rem).add(new long[]{l, r, v});
            }
        }

        // Process small k
        for (int k = 1; k < B; k++) {
            for (int r = 0; r < k; r++) {

                List<Integer> indices = new ArrayList<>();
                for (int i = r; i < n; i += k) {
                    indices.add(i);
                }

                int m = indices.size();
                long[] diff = new long[m + 1];
                Arrays.fill(diff, 1);

                // apply queries
                for (long[] q : map.get(k).get(r)) {
                    int l = (int)q[0], rr = (int)q[1], v = (int)q[2];

                    // find positions in indices
                    int left = (l - r + k - 1) / k;
                    int right = (rr - r) / k;

                    if (left < m && right >= 0 && left <= right) {
                        diff[left] = (diff[left] * v) % MOD;
                        if (right + 1 < m) {
                            diff[right + 1] = (diff[right + 1] * modInv(v)) % MOD;
                        }
                    }
                }

                // prefix multiply
                long cur = 1;
                for (int i = 0; i < m; i++) {
                    cur = (cur * diff[i]) % MOD;
                    nums[indices.get(i)] = (int)((nums[indices.get(i)] * cur) % MOD);
                }
            }
        }

        // XOR
        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }

    // modular inverse (MOD is prime)
    long modInv(long x) {
        return pow(x, MOD - 2);
    }

    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}