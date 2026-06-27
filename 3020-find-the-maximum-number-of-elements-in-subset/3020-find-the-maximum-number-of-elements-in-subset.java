import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge((long) n, 1, Integer::sum);

        int result = 0;

        // x=1: pattern is [1,1,...,1], odd count only
        if (freq.containsKey(1L)) {
            int ones = freq.get(1L);
            result = (ones % 2 == 1) ? ones : ones - 1;
        }

        for (long x : freq.keySet()) {
            if (x == 1) continue;

            // Skip x only if sqrt(x) exists with freq>=2
            // (meaning a smaller base can actually wrap around x as a pair)
            long sq = (long) Math.round(Math.sqrt(x));
            if (sq * sq == x && freq.getOrDefault(sq, 0) >= 2) continue;

            int len = 0;
            long cur = x;

            while (true) {
                int curFreq = freq.getOrDefault(cur, 0);
                if (curFreq == 0) break;

                long nxt = cur * cur;
                boolean nxtExists = nxt <= 1_000_000_000L && freq.containsKey(nxt);

                if (curFreq >= 2 && nxtExists) {
                    len += 2;
                    cur = nxt;
                } else {
                    // cur is the center
                    len += 1;
                    break;
                }
            }

            result = Math.max(result, len);
        }

        return result;
    }
}