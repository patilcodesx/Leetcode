class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n - 1;
        int collisions = 0;

        // Skip leading 'L'
        while (i < n && directions.charAt(i) == 'L')
            i++;

        // Skip trailing 'R'
        while (j >= 0 && directions.charAt(j) == 'R')
            j--;

        // Now every R, L, S inside will cause collision except 'S'
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
