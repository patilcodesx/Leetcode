class Solution {
    public void moveZeroes(int[] nums) {
        int insertzeros = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[insertzeros] = nums[i];
                insertzeros++;
            }
        }

        while(insertzeros < nums.length){
            nums[insertzeros] = 0;
            insertzeros ++;
        }

        
    }
}