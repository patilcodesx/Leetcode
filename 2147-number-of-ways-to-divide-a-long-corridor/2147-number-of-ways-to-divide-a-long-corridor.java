class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        
        int seatCount = 0;
        long ways = 1;
        int plantsBetween = 0;
        boolean countingPlants = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                // When a new seat-pair starts
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
                countingPlants = seatCount % 2 == 0;
            } else if (c == 'P' && countingPlants) {
                plantsBetween++;
            }
        }

        // Total seats must be even and at least 2
        return seatCount >= 2 && seatCount % 2 == 0 ? (int) ways : 0;
    }
}
