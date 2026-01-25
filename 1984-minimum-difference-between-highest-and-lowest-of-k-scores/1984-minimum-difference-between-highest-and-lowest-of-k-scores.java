class Solution {
    public int minimumDifference(int[] nums, int k) {
        int diff;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

       for(int i=0;i<=nums.length-k;i++){
          diff = nums[i+k-1] - nums[i];
          min = Math.min(diff,min);
       }
        return min;
    }
}