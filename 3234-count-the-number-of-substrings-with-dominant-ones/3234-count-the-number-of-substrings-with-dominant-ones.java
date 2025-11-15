class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        long ans = 0;

        // Max possible zeros in a valid substring:
        // z^2 + z <= n  -> quadratic formula
        int maxZero = (int) ((-1 + Math.sqrt(1 + 4.0 * n)) / 2);

        // Try all possible counts of zeros in a substring.
        for (int zeroTarget = 0; zeroTarget <= maxZero; zeroTarget++) {
            int[] count = new int[2]; // count[0] = zeros, count[1] = ones
            int l = 0;
            int lastInvalidPos = -1; // last position that made the window invalid

            for (int r = 0; r < n; r++) {
                int bit = s.charAt(r) - '0';
                count[bit]++;

                // Shrink from left as much as possible while keeping the ability
                // to have exactly zeroTarget zeros and at least zeroTarget^2 ones.
                while (l < r) {
                    char chL = s.charAt(l);

                    if (chL == '0' && count[0] > zeroTarget) {
                        // Too many zeros – we MUST drop this '0'.
                        count[0]--;
                        lastInvalidPos = l;
                        l++;
                    } else if (chL == '1' && count[1] - 1 >= zeroTarget * zeroTarget) {
                        // We can safely drop this '1' and still keep enough ones.
                        count[1]--;
                        l++;
                    } else {
                        // Further shrinking would break our ability to meet constraints.
                        break;
                    }
                }

                // Now window [l, r] is as tight as possible.
                // If it has the exact zeroTarget zeros and enough ones,
                // all starts in (lastInvalidPos, l] with end r are valid.
                if (count[0] == zeroTarget && count[1] >= zeroTarget * zeroTarget) {
                    ans += (l - lastInvalidPos);
                }
            }
        }

        // The problem's return type is int, but the count can fit in int for given constraints.
        return (int) ans;
    }
}
