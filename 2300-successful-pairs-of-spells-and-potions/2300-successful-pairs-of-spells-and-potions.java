import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            long requiredPotion = (success + spells[i] - 1) / spells[i];
            int left = 0, right = potions.length;

            while (left < right) {
                int mid = (left + right) / 2;
                if (potions[mid] >= requiredPotion) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = potions.length - left;
        }

        return result;
    }
}
