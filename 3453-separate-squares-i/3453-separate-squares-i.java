class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        for (int[] sq : squares) {
            totalArea += (double) sq[2] * sq[2];
        }
        double half = totalArea / 2.0;

        // Establish binary search boundary
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for (int[] sq : squares) {
            minY = Math.min(minY, sq[1]);
            maxY = Math.max(maxY, (long) sq[1] + sq[2]);
        }

        double lo = minY, hi = maxY;
        for (int iter = 0; iter < 80; iter++) { // ~1e-5 precision
            double mid = (lo + hi) / 2.0;
            double belowArea = 0.0;
            for (int[] sq : squares) {
                double y0 = sq[1], l = sq[2];
                if (mid <= y0) {
                    // no contribution
                } else if (mid >= y0 + l) {
                    belowArea += l * l;
                } else {
                    belowArea += (mid - y0) * l;
                }
            }

            if (belowArea < half) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
