import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        // Build transition map
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }

        return dfs(bottom, "", 0, map);
    }

    private boolean dfs(String bottom, String next, int index,
                        Map<String, List<Character>> map) {

        // If pyramid reaches the top
        if (bottom.length() == 1) return true;

        // If next level is completed, recurse on it
        if (index == bottom.length() - 1) {
            return dfs(next, "", 0, map);
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) return false;

        // Try all possible characters
        for (char c : map.get(key)) {
            if (dfs(bottom, next + c, index + 1, map)) {
                return true;
            }
        }

        return false;
    }
}
