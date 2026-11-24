class Solution {
    public int majorityElement(int[] nums) {
      int threshold = nums.length/2;

      for(int candidate: nums){
        int frequency = 0;

        for(int value: nums){
            if(value==candidate){
                frequency++;
            }
        }
        if(frequency>threshold){
            return candidate;
        }
      }

      return -1;
    }
    
}