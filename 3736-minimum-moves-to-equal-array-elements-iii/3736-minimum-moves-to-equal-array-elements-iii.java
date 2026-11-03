
class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0], moves = 0;

        for (int n : nums) {
            max = Math.max(max, n); 
        }

        for(int n: nums){
            moves += max - n;
        }
        
        return moves;
    }
}
