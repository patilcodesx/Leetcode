class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHGap = getMaxGap(hBars);
        int maxVGap = getMaxGap(vBars);

        int side = Math.min(maxHGap, maxVGap);
        return side * side;
    }

     private int getMaxGap(int[] bars) {
        Arrays.sort(bars);

        int maxGap = 1;
        int current = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }
            maxGap = Math.max(maxGap, current);
        }

        return maxGap + 1; // +1 because bars create holes
    }
}